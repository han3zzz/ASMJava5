package com.spring.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.spring.beans.CartForm;
import com.spring.beans.ChangeForm;
import com.spring.beans.ForgetForm;
import com.spring.beans.LoginForm;
import com.spring.beans.RegisterForm;
import com.spring.entities.Account;
import com.spring.entities.Cart;
import com.spring.entities.Category;
import com.spring.entities.HoaDon;
import com.spring.entities.HoaDonChiTiet;
import com.spring.entities.KichThuoc;
import com.spring.entities.Product;
import com.spring.entities.Product_KichThuoc;
import com.spring.services.AccountService;
import com.spring.services.CartService;
import com.spring.services.CategoryService;
import com.spring.services.HoaDonChiTietService;
import com.spring.services.HoaDonService;
import com.spring.services.KichThuocService;
import com.spring.services.ProductKichThuocService;
import com.spring.services.ProductService;
import com.spring.services.impl.EmailService;

import freemarker.template.TemplateException;

@Controller
public class HomePage {
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;
	@Autowired
	ProductService service;
	@Autowired
	ProductKichThuocService productKichThuocService;
	@Autowired
	AccountService accountService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CartService cartService;
	@Autowired
	KichThuocService kichThuocService;
	@Autowired
	EmailService emailService;
	@Autowired
	HoaDonService hoaDonService;
	@Autowired
	HoaDonChiTietService hoaDonChiTietService;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	HttpServletResponse resp;
	@GetMapping(value = { "/", "/index", "/home" })

	public String indexPage(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
		Integer pageSize = 8;
//		int start = (pageNum - 1) * pageSize + 1 ;
//		int end = start + pageSize;
//		List<Product> productPagetion = list.stream().filter(p -> {
//    		return p.getId() >= start && p.getId() < end ;
//    	}).collect(Collectors.toList());
		List<Product> list = service.getAll(pageNum - 1, pageSize).getContent();
		List<Product> count = service.count();
		model.addAttribute("list", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		return "homePage";
	}

	@GetMapping("/detail/{id}")
	public String detailPage(Model model, @PathVariable(name = "id") Integer id) {
		Product product = service.getProductbyId(id);
		Integer count = 0;
		List<Product_KichThuoc> list = productKichThuocService.count(id);
		for (Product_KichThuoc product_KichThuoc : list) {
			count += product_KichThuoc.getSoLuong();
		}
		model.addAttribute("data", new CartForm());
		model.addAttribute("listKT", list);
		model.addAttribute("count", count);
		model.addAttribute("p", product);
		return "detailProductPage";
	}
	@PostMapping("detail/{id}")
	public String detail(Model model , RedirectAttributes redirect ,
			@ModelAttribute(name = "data") CartForm form , BindingResult result) {
		Locale locale = RequestContextUtils.getLocale(request);
		Product pro = service.getProductbyId(form.getId());
		Integer count = 0;
		List<Product_KichThuoc> list = productKichThuocService.count(form.getId());
		for (Product_KichThuoc product_KichThuoc : list) {
			count += product_KichThuoc.getSoLuong();
		}
		model.addAttribute("listKT", list);
		model.addAttribute("count", count);
		model.addAttribute("p", pro);
		Account acc = accountService.getByUsername(form.getUsername());
		if (acc == null) {
			request.setAttribute("message", messageSource.getMessage("message.detail.dangnhap", null, locale));
			request.setAttribute("type", "error");
			return "detailProductPage";
		}
		if (count == 0) {
			request.setAttribute("message", messageSource.getMessage("message.detail.soluong", null, locale));
			request.setAttribute("type", "error");
			return "detailProductPage";
		}
		if (!result.hasErrors()) {
			Account account = accountService.getByUsername(form.getUsername());	
			Product product = service.getProductbyId(form.getIdProduct());
			Integer kichThuoc = form.getKichthuoc();
			if (kichThuoc == null) {
				request.setAttribute("message", messageSource.getMessage("message.detail.kichthuoc", null, locale));
				request.setAttribute("type", "error");
				return "detailProductPage";
			}
			BigDecimal donGia = form.getDongia();
			KichThuoc kt = kichThuocService.getKichThuocbyId(kichThuoc);
			Cart c = cartService.getById(form.getUsername(), form.getIdProduct(), kt.getTenKichThuoc());
			if (c == null) {
				Cart cart = new Cart();
				cart.setUsername(account);
				cart.setProduct(product);
				cart.setKichThuoc(kt.getTenKichThuoc());
				cart.setDonGia(donGia);
				cart.setSoLuong(1);
				if (cartService.add(cart) != null) {
					Product_KichThuoc p = productKichThuocService.getByIdProduct(product.getId(), kt.getIdKichThuoc());
					p.setSoLuong(p.getSoLuong() -1);
					productKichThuocService.update(p);
					redirect.addFlashAttribute("message" ,messageSource.getMessage("message.detail.thanhcong", null, locale));
					redirect.addFlashAttribute("type", "success");
					return "redirect:/detail/{id}";
				}
			}
			else {
				c.setSoLuong(c.getSoLuong() + 1);
				if (cartService.update(c) != null) {
					Product_KichThuoc p = productKichThuocService.getByIdProduct(product.getId(), kt.getIdKichThuoc());
					p.setSoLuong(p.getSoLuong() -1);
					productKichThuocService.update(p);
					redirect.addFlashAttribute("message" ,messageSource.getMessage("message.detail.thanhcong", null, locale));
					redirect.addFlashAttribute("type", "success");
					return "redirect:/detail/{id}";
				}
			}
			
			
			
		}
				return "detailProductPage";
		
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("data", new LoginForm());
		return "loginPage";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("data", new RegisterForm());
		return "registerPage";
	}

	@PostMapping("/register")
	public String register(Model model, RedirectAttributes redirect,@Valid @ModelAttribute("data") RegisterForm form,
			BindingResult result) {
		Locale locale = RequestContextUtils.getLocale(request);
		String username = form.getUsername();
		String password = form.getPassword();
		String repassword = form.getRePassword();
		String email = form.getEmail();
		if (!result.hasErrors()) {
			if (accountService.getByUsername(username) != null) {
				request.setAttribute("message", messageSource.getMessage("message.register.usertontai", null, locale));
				request.setAttribute("type", "error");
				return "registerPage";
			}
			if (!password.equals(repassword)) {
				request.setAttribute("message", messageSource.getMessage("message.register.matkhauchuakhop", null, locale));
				request.setAttribute("type", "error");
				return "registerPage";
			}
			if (request.getParameter("checkbox") == null) {
				request.setAttribute("message", messageSource.getMessage("message.register.dieukhoan", null, locale));
				request.setAttribute("type", "error");
				return "registerPage";
			}
			Account acc = new Account();
			acc.setUsername(username);
			acc.setPassword(password);
			acc.setEmail(email);
			acc.setRole(1);
			acc.setActive(0);
			if (accountService.add(acc) != null) {
				redirect.addFlashAttribute("message", messageSource.getMessage("message.register.thanhcong", null, locale));
				redirect.addFlashAttribute("type", "success");
				return "redirect:/register";
			}
			
			
		}
		return "registerPage";
	}
	@PostMapping("/login")
	public String login(Model model, RedirectAttributes redirect,@Valid @ModelAttribute("data") LoginForm form,
			BindingResult result) {
		Locale locale = RequestContextUtils.getLocale(request);
		String username = form.getUsername();
		String password = form.getPassword();
		if (!result.hasErrors()) {
			Account account = accountService.authention(username, password);
			if (account != null) {
				session.setAttribute("account", account);
				redirect.addFlashAttribute("message" ,messageSource.getMessage("message.login.thanhcong",null,locale) );
				redirect.addFlashAttribute("type", "success");
				return "redirect:/index";
			}
			else {
				request.setAttribute("message", messageSource.getMessage("message.login.thatbai", null, locale));
				request.setAttribute("type", "error");
			}
		}
		return "loginPage";
	}

	@GetMapping("/logout")
	public String logout(RedirectAttributes redirect) {
		session.removeAttribute("account");

		return "redirect:/index";
	}

	@GetMapping("/product")
	public String productPage(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
		Integer pageSize = 8;
		List<Product> list = service.getAll(pageNum - 1, pageSize).getContent();
		List<Product> count = service.count();
		List<Category> listCate = categoryService.count();
		model.addAttribute("listCate", listCate);
		model.addAttribute("list", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		return "productPage";
	}

	@GetMapping("/product/{id}")
	public String productPage(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@PathVariable(name = "id") Integer id) {
		Integer pageSize = 8;
		List<Product> list = service.getAllbyCate(pageNum - 1, pageSize, id).getContent();
		List<Product> count = service.countbyCate(id);
		List<Category> listCate = categoryService.count();
		model.addAttribute("id", id);
		model.addAttribute("listCate", listCate);
		model.addAttribute("list", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		return "productPage";
	}

	@GetMapping("/info")
	public String infoPage() {
		return "infoPage";
	}

	@GetMapping("/manage")
	public String managePage() {
		return "ManagePage";
	}

	@GetMapping("/forget")
	public String forgetPage(Model model) {
		model.addAttribute("data", new ForgetForm());
		return "forgetPage";
	}
	@PostMapping("/forget")
	public String forget(Model model ,@Valid @ModelAttribute(name = "data") ForgetForm form , BindingResult result , RedirectAttributes redirect) {
		Locale locale = RequestContextUtils.getLocale(request);
		if (!result.hasErrors()) {
			try {
				Account account = accountService.getByUsername(form.getUsername());
				if (account == null) {
					request.setAttribute("message", messageSource.getMessage("message.forget.username", null, locale));
					request.setAttribute("type", "error");
					return "forgetPage";
				}
				if (!account.getEmail().equals(form.getEmail())) {
					request.setAttribute("message", messageSource.getMessage("message.forget.email", null, locale));
					request.setAttribute("type", "error");
					return "forgetPage";
				}
				redirect.addFlashAttribute("message", messageSource.getMessage("message.forget.thanhcong", null, locale));
				redirect.addFlashAttribute("type", "success");
				emailService.SendMailForget(form.getUsername(), form.getEmail());
				return "redirect:/forget";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "forgetPage";
	}
	@GetMapping("/change")
	public String changePage(Model model) {
		model.addAttribute("data", new ChangeForm());
		return "changePage";
	}
	@PostMapping("/change")
	public String change(Model model , RedirectAttributes redirect , @Valid @ModelAttribute(name = "data") ChangeForm form , BindingResult result) {
		Locale locale = RequestContextUtils.getLocale(request);
		if (!result.hasErrors()) {
			Account account = (Account) session.getAttribute("account");
			if (accountService.authention(account.getUsername(), form.getPasscu()) == null) {
				request.setAttribute("message", messageSource.getMessage("message.change.matkhaucu", null, locale));
				request.setAttribute("type", "error");
				return "changePage";
			}
			if (!form.getPassmoi().equals(form.getRepassmoi())) {
				request.setAttribute("message", messageSource.getMessage("message.change.xacnhan", null, locale));
				request.setAttribute("type", "error");
				return "changePage";
			}
			account.setPassword(form.getPassmoi());
			accountService.update(account);
			redirect.addFlashAttribute("message", messageSource.getMessage("message.change.thanhcong", null, locale));
			redirect.addFlashAttribute("type", "success");
			return "redirect:/change";
		}
		return "changePage";
	}
	@GetMapping("/403")
	public String phanQuyenPage() {
		return "403";
	}
	@GetMapping("/my-order")
	public String myOrderPage(Model model , @RequestParam(name = "pageNum" , defaultValue = "1") Integer pageNum) {
		Account account = (Account) session.getAttribute("account");
		Integer pageSize = 10;
		List<HoaDon> list = hoaDonService.getAll(pageNum - 1, pageSize, account.getUsername()).getContent();
		List<HoaDon> count = hoaDonService.count(account.getUsername());
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		model.addAttribute("listHoaDon", list);
		return "MyOrderPage";
	}
	@GetMapping("/my-order/huy/{id}")
	public String myOrderhuyPage(Model model , RedirectAttributes redirect,@PathVariable(name = "id") Integer id) {
		Locale locale = RequestContextUtils.getLocale(request);
		HoaDon hoaDon = hoaDonService.getHoaDonbyId(id);
		if (hoaDon.getTrangThai() == 2) {
			redirect.addFlashAttribute("message", "Đơn hàng đã được giao trước đó");
			redirect.addFlashAttribute("type", "error");
			return "redirect:/my-order";
		}
		hoaDon.setTrangThai(1);
		hoaDonService.update(hoaDon);
		List<HoaDonChiTiet> hdcts = hoaDonChiTietService.getbyId(id);
		for (HoaDonChiTiet hoaDonChiTiet : hdcts) {
			KichThuoc kichThuoc = kichThuocService.getKichThuocbyName(hoaDonChiTiet.getKichThuoc());
			Product_KichThuoc p = productKichThuocService.getByIdProduct(hoaDonChiTiet.getProduct().getId(), kichThuoc.getIdKichThuoc());
			p.setSoLuong(p.getSoLuong() + hoaDonChiTiet.getSoLuong());
			productKichThuocService.update(p);
			
		}
		redirect.addFlashAttribute("message", messageSource.getMessage("message.myorder.huy", null, locale));
		redirect.addFlashAttribute("type", "success");
		return "redirect:/my-order";
	}
	@GetMapping("/my-order/chitiet/{id}")
	public String myOrderchitietPage(Model model , RedirectAttributes redirect,@PathVariable(name = "id") Integer id) {
		List<HoaDonChiTiet> hoaDonChiTiets = hoaDonChiTietService.getbyId(id);
		request.setAttribute("list", hoaDonChiTiets);
		return "ChiTietPage";
	}
	@GetMapping("/manage-order")
	public String manageOrderPage(Model model , @RequestParam(name = "pageNum" , defaultValue = "1") Integer pageNum) {
		Integer pageSize = 10;
		List<HoaDon> list = hoaDonService.getAllPage(pageNum - 1, pageSize).getContent();
		List<HoaDon> count = hoaDonService.countPage();
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		model.addAttribute("listHoaDon", list);
		return "ManageOrderPage";
	}
	@GetMapping("/manage-order/huy/{id}")
	public String manageOrderhuyPage(Model model , RedirectAttributes redirect,@PathVariable(name = "id") Integer id) {
		Locale locale = RequestContextUtils.getLocale(request);
		HoaDon hoaDon = hoaDonService.getHoaDonbyId(id);
		if (hoaDon.getTrangThai() == 1) {
			redirect.addFlashAttribute("message", "Đơn hàng đã được hủy trước đó");
			redirect.addFlashAttribute("type", "error");
			return "redirect:/my-order";
		}
		hoaDon.setTrangThai(1);
		hoaDonService.update(hoaDon);
		List<HoaDonChiTiet> hdcts = hoaDonChiTietService.getbyId(id);
		for (HoaDonChiTiet hoaDonChiTiet : hdcts) {
			KichThuoc kichThuoc = kichThuocService.getKichThuocbyName(hoaDonChiTiet.getKichThuoc());
			Product_KichThuoc p = productKichThuocService.getByIdProduct(hoaDonChiTiet.getProduct().getId(), kichThuoc.getIdKichThuoc());
			p.setSoLuong(p.getSoLuong() + hoaDonChiTiet.getSoLuong());
			productKichThuocService.update(p);
			
		}
		redirect.addFlashAttribute("message", messageSource.getMessage("message.manageorder.huy", null, locale));
		redirect.addFlashAttribute("type", "success");
		return "redirect:/manage-order";
	}
	@GetMapping("/manage-order/thanhtoan/{id}")
	public String manageOrderthanhtoanPage(Model model , RedirectAttributes redirect,@PathVariable(name = "id") Integer id) {
		Locale locale = RequestContextUtils.getLocale(request);
		HoaDon hoaDon = hoaDonService.getHoaDonbyId(id);
		if (hoaDon.getTrangThai() == 1) {
			redirect.addFlashAttribute("message", "Đơn hàng đã được hủy trước đó");
			redirect.addFlashAttribute("type", "error");
			return "redirect:/my-order";
		}
		hoaDon.setTrangThai(2);
		hoaDonService.update(hoaDon);
		
		redirect.addFlashAttribute("message", messageSource.getMessage("message.manageorder.xacnhan", null, locale));
		redirect.addFlashAttribute("type", "success");
		return "redirect:/manage-order";
	}
	@GetMapping("/manage-order/chitiet/{id}")
	public String manageOrderchitietPage(Model model , RedirectAttributes redirect,@PathVariable(name = "id") Integer id) {
		List<HoaDonChiTiet> hoaDonChiTiets = hoaDonChiTietService.getbyId(id);
		request.setAttribute("list", hoaDonChiTiets);
		return "ChiTiet2Page";
	}

}
