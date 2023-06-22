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

import com.spring.beans.AccountForm;
import com.spring.entities.Account;
import com.spring.services.AccountService;


@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService service;
	@Autowired
	HttpServletRequest request;
	@Autowired
	private MessageSource messageSource;

	@GetMapping(value = { "", "/", "/index" })
	public String indexPage(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
		Integer pageSize = 8;
		List<Account> list = service.getAll(pageNum - 1, pageSize).getContent();
		List<Account> count = service.count();
		model.addAttribute("list", list);
		Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
				: Math.round(count.size() / pageSize) + 1;
		model.addAttribute("count", count1);
		return "ManageUser";
	}

	@GetMapping("/add")
	public String addPage(Model model) {
		model.addAttribute("data", new AccountForm());
		return "ManageUserAdd";
	}

	@PostMapping("/add")
	public String add(Model model,RedirectAttributes redirect,@Valid @ModelAttribute(name = "data") AccountForm form, 
			BindingResult result) {
		Locale locale = RequestContextUtils.getLocale(request);
		if (!result.hasErrors()) {
			if (service.getByUsername(form.getUsername()) != null) {
				request.setAttribute("message", messageSource.getMessage("message.admin.account.username", null, locale));
				request.setAttribute("type", "error");
				return "ManageUserAdd";
			}
			Account account = form.data(null);
			account.setActive(0);
			if (service.add(account) != null) {
				redirect.addFlashAttribute("message",messageSource.getMessage("message.admin.account.thanhcong", null, locale));
				redirect.addFlashAttribute("type","success");
				return "redirect:/account";
			}
		}
		return "ManageUserAdd";
	}

	@GetMapping("/update/{username}")
	public String updatePage(Model model, @PathVariable(name = "username") String username) {
		Account account = service.getByUsername(username);
		model.addAttribute("account", account);
		model.addAttribute("data", new AccountForm());
		return "ManageUserUpdate";
	}

	@PostMapping("/update")
	public String update(Model model,RedirectAttributes redirect,@Valid @ModelAttribute(name = "data") AccountForm form, 
			BindingResult result) {
		Locale locale = RequestContextUtils.getLocale(request);
		if (!result.hasErrors()) {
			Account account = service.getByUsername(form.getUsername());
			Account acc = form.data(account);
			if (service.update(acc) != null) {
				redirect.addFlashAttribute("message",messageSource.getMessage("message.admin.account.thanhcongsua", null, locale));
				redirect.addFlashAttribute("type","success");
				return "redirect:/account";
			}
		}
		return "ManageUserUpdate";
	}

	@GetMapping("/delete/{username}")
	public String deletePage(Model model, @PathVariable(name = "username") String username, RedirectAttributes redirect) {
		Locale locale = RequestContextUtils.getLocale(request);
		Account account = service.getByUsername(username);
		if (service.delete(account) != null) {
			redirect.addFlashAttribute("message",messageSource.getMessage("message.admin.account.thanhcongxoa", null, locale));
			redirect.addFlashAttribute("type","success");
			return "redirect:/account";
		}
		return "ManageUser";
	}
}
