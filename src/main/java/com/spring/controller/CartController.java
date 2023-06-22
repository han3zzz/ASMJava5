package com.spring.controller;


import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.spring.beans.ThanhToanForm;
import com.spring.entities.Account;
import com.spring.entities.Cart;
import com.spring.entities.HoaDon;
import com.spring.entities.HoaDonChiTiet;
import com.spring.entities.KichThuoc;
import com.spring.entities.Product_KichThuoc;
import com.spring.services.CartService;
import com.spring.services.HoaDonChiTietService;
import com.spring.services.HoaDonService;
import com.spring.services.KichThuocService;
import com.spring.services.ProductKichThuocService;
import com.spring.services.impl.EmailService;

import freemarker.template.TemplateException;
@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService service;
	@Autowired
	HttpSession session;
	@Autowired
	ProductKichThuocService productKichThuocService;
	@Autowired
	KichThuocService kichThuocService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HoaDonService hdService;
	@Autowired
	HoaDonChiTietService hdctService;
	@Autowired
	EmailService emailService;
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(value = {"","/","/index"})
	public String indexPage(Model model) {
		Account account = (Account) session.getAttribute("account");
		List<Cart> list = service.getCartbyUser(account.getUsername());
		Double tongTien = 0.0;
		for (Cart cart : list) {
			String tien = String.valueOf(cart.getDonGia());
			 tongTien += (cart.getSoLuong() * Double.valueOf(tien));
		}
		model.addAttribute("tongTien", tongTien);
		model.addAttribute("listCart", list);
		model.addAttribute("data", new ThanhToanForm());
		return "cartPage";
	}
	@GetMapping("/thanhtoan")
	public String thanhtoanPage(Model model) {
		Account account = (Account) session.getAttribute("account");
		List<Cart> list = service.getCartbyUser(account.getUsername());
		Double tongTien = 0.0;
		for (Cart cart : list) {
			String tien = String.valueOf(cart.getDonGia());
			 tongTien += (cart.getSoLuong() * Double.valueOf(tien));
		}
		model.addAttribute("tongTien", tongTien);
		model.addAttribute("listCart", list);
		model.addAttribute("data", new ThanhToanForm());
		return "cartPage";
	}
	@GetMapping("/giam")
	public String giam(Model model , @RequestParam(name = "id") Integer id , @RequestParam(name = "kichThuoc") String kichThuoc , RedirectAttributes redirect) {
		
		Account account = (Account) session.getAttribute("account");
		KichThuoc kt = kichThuocService.getKichThuocbyName(kichThuoc);
		Product_KichThuoc p = productKichThuocService.getByIdProduct(id, kt.getIdKichThuoc());
		Cart cart = service.getById(account.getUsername(), id, kichThuoc);
		if (cart.getSoLuong()  == 1) {
			service.delete(cart);
			return "redirect:/cart";
		}
		cart.setSoLuong(cart.getSoLuong() - 1);
		p.setSoLuong(p.getSoLuong() +1);
		productKichThuocService.update(p);
		
		service.update(cart);
		return "redirect:/cart";
	}
	@GetMapping("/them")
	public String them(Model model , @RequestParam(name = "id") Integer id , @RequestParam(name = "kichThuoc") String kichThuoc,RedirectAttributes redirect) {
		Locale locale = RequestContextUtils.getLocale(request);
		Account account = (Account) session.getAttribute("account");
		KichThuoc kt = kichThuocService.getKichThuocbyName(kichThuoc);
		Product_KichThuoc p = productKichThuocService.getByIdProduct(id, kt.getIdKichThuoc());
		Cart cart = service.getById(account.getUsername(), id, kichThuoc);
		if (p.getSoLuong() == 0 ) {
			redirect.addFlashAttribute("message", messageSource.getMessage("message.cart.them", null, locale));
			redirect.addFlashAttribute("type", "error");
			
			return "redirect:/cart";
		}
		p.setSoLuong(p.getSoLuong() - 1);
		productKichThuocService.update(p);
		
		cart.setSoLuong(cart.getSoLuong() + 1);
		service.update(cart);
		return "redirect:/cart";
	}
	@GetMapping("/delete")
	public String delete(Model model , @RequestParam(name = "id") Integer id , @RequestParam(name = "kichThuoc") String kichThuoc,RedirectAttributes redirect) {
		Locale locale = RequestContextUtils.getLocale(request);
		Account account = (Account) session.getAttribute("account");
		Cart cart = service.getById(account.getUsername(), id, kichThuoc);
		KichThuoc kt = kichThuocService.getKichThuocbyName(kichThuoc);
		Product_KichThuoc p = productKichThuocService.getByIdProduct(id, kt.getIdKichThuoc());
		p.setSoLuong(p.getSoLuong() + cart.getSoLuong());
		
		productKichThuocService.update(p);
		service.delete(cart);
		redirect.addFlashAttribute("message",messageSource.getMessage("message.cart.xoa", null, locale));
		redirect.addFlashAttribute("type", "success");
		
		return "redirect:/cart";
	}
	@PostMapping("/thanhtoan")
	public String thanhToan(Model model , RedirectAttributes redirect , @Valid @ModelAttribute(name = "data") ThanhToanForm form , BindingResult result) {
		Locale locale = RequestContextUtils.getLocale(request);
		Account account = (Account) request.getSession().getAttribute("account");
		List<Cart> list = service.getCartbyUser(account.getUsername());
		Double tongTien = 0.0;
		for (Cart cart : list) {
			String tien = String.valueOf(cart.getDonGia());
			 tongTien += (cart.getSoLuong() * Double.valueOf(tien));
		}
		model.addAttribute("tongTien", tongTien);
		model.addAttribute("listCart", list);
		if (result.hasErrors()) {
			return "cartPage";
		}
		
		List<Cart> cart = service.getCartbyUser(account.getUsername());
		if (cart.isEmpty()) {
			request.setAttribute("message", messageSource.getMessage("message.cart.giohang", null, locale));
			request.setAttribute("type", "error");
			return "cartPage";
		}
		if (!result.hasErrors()) {
			HoaDon hd = new HoaDon();
			hd.setUsername(account);
			hd.setNguoiNhan(form.getTenNguoiNhan());
			hd.setDiaChi(form.getDiaChiNguoiNhan());
			hd.setSoDienThoai(form.getSdtNguoiNhan());
			DateTimeFormatter f = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			ZonedDateTime now = ZonedDateTime.now();
			String ngayTao =  f.format(now);
			hd.setTrangThai(0);
			hd.setNgayTao(ngayTao);
			hdService.add(hd);
			for (Cart c : cart) {
				HoaDonChiTiet hdct = new HoaDonChiTiet();
				hdct.setHoaDon(hd);
				hdct.setProduct(c.getProduct());
				hdct.setDonGia(c.getDonGia());
				hdct.setSoLuong(c.getSoLuong());
				hdct.setKichThuoc(c.getKichThuoc());
				hdctService.add(hdct);
				service.delete(c);
				
			}
			redirect.addFlashAttribute("message", messageSource.getMessage("message.cart.thanhcong", null, locale));
			redirect.addFlashAttribute("type", "success");
			try {
				emailService.SendMailOrder(account.getUsername(), account.getEmail(), hd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/cart";
		}
		return "cartPage";
	}
}
