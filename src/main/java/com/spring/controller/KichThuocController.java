package com.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.spring.beans.KichThuocForm;
import com.spring.entities.KichThuoc;
import com.spring.services.KichThuocService;

@Controller
@RequestMapping("/kichthuoc")
public class KichThuocController {

	@Autowired
	private KichThuocService service;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	HttpServletRequest request;
	@GetMapping(value = { "", "/", "/index" })
	public String indexPage(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
		Integer pageSize = 5;
		List<KichThuoc> list = service.getAll(pageNum - 1, pageSize).getContent();
		List<KichThuoc> count = service.count();
		model.addAttribute("list", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		return "ManageKichThuoc";
	}

	@GetMapping("/add")
	public String addPage(Model model) {
		model.addAttribute("data", new KichThuocForm());
		return "ManageKichThuocAdd";
	}

	@PostMapping("/add")
	public String add(Model model, RedirectAttributes redirect,@Valid @ModelAttribute(name = "data") KichThuocForm form,
			BindingResult result) {
		Locale locale = RequestContextUtils.getLocale(request);
		KichThuoc kichThuoc = form.data(null);
		if (!result.hasErrors()) {
			kichThuoc.setTrangThai(0);

			if (service.add(kichThuoc) != null) {
				redirect.addFlashAttribute("message",messageSource.getMessage("message.admin.kichthuoc.thanhcong", null, locale));
				redirect.addFlashAttribute("type","success");
				return "redirect:/kichthuoc";
			}
		}
		return "ManageKichThuocAdd";
	}

	@GetMapping("/update/{id}")
	public String updatePage(Model model, @PathVariable(name = "id") Integer id) {
		KichThuoc kt = service.getKichThuocbyId(id);
		model.addAttribute("kt", kt);
		model.addAttribute("data", new KichThuocForm());
		return "ManageKichThuocUpdate";
	}

	@PostMapping("/update")
	public String update(Model model, RedirectAttributes redirect,@Valid @ModelAttribute(name = "data") KichThuocForm form,
			BindingResult result) {
		Locale locale = RequestContextUtils.getLocale(request);
		if (!result.hasErrors()) {
			KichThuoc kt = service.getKichThuocbyId(form.getId());
			KichThuoc kichThuoc = form.data(kt);
			if (service.update(kichThuoc) != null) {
				redirect.addFlashAttribute("message",messageSource.getMessage("message.admin.kichthuoc.thanhcongsua", null, locale));
				redirect.addFlashAttribute("type","success");
				return "redirect:/kichthuoc";
			}
		}
		return "ManageKichThuocUpdate";
	}

	@GetMapping("/delete/{id}")
	public String deletePage(Model model, @PathVariable(name = "id") Integer id , RedirectAttributes redirect) {
		Locale locale = RequestContextUtils.getLocale(request);
		KichThuoc kichThuoc = service.getKichThuocbyId(id);
		if (service.delete(kichThuoc) != null) {
			redirect.addFlashAttribute("message",messageSource.getMessage("message.admin.kichthuoc.thanhcongxoa", null, locale));
			redirect.addFlashAttribute("type","success");
			return "redirect:/kichthuoc";
		}
		return "ManageKichThuoc";
	}
}
