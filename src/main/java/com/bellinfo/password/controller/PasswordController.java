package com.bellinfo.password.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bellinfo.password.model.Ecom;
import com.bellinfo.password.model.GeneratePassword;
import com.bellinfo.password.model.Login;
import com.bellinfo.password.model.Registration;
import com.bellinfo.password.model.SocialMedia;
import com.bellinfo.password.model.StoreBankDetails;
import com.bellinfo.password.service.Service;

@Controller
public class PasswordController {

	@Autowired
	Service service;

	public void setService(Service service) {
		this.service = service;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegistration(Model model) {
		Registration reg = new Registration();
		model.addAttribute("registration", reg);
		return "registration";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
		Login log = new Login();
		model.addAttribute("login", log);
		return "login";

	}

	@RequestMapping(value = "/bank", method = RequestMethod.GET)
	public String storeBank(Model model) {
		StoreBankDetails sbd = new StoreBankDetails();
		model.addAttribute("bank", sbd);
		return "bank";

	}

	@RequestMapping(value = "/ecomm", method = RequestMethod.GET)
	public String storeEcom(Model model) {
		Ecom ec = new Ecom();
		model.addAttribute("ecom", ec);
		return "Ecom";

	}

	@RequestMapping(value = "/social", method = RequestMethod.GET)
	public String storeSocial(Model model) {
		SocialMedia sm = new SocialMedia();
		model.addAttribute("social", sm);
		return "social";

	}

	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public String bankView(Model model, @ModelAttribute SessionListener listen,
			HttpServletRequest request, HttpServletResponse response) {
		listen.session = request.getSession(true);
		HttpSessionEvent event = new HttpSessionEvent(listen.session);
		String user = (String) listen.session.getAttribute("attr");
		List<GeneratePassword> list = null;
		try {
			GeneratePassword gp = new GeneratePassword();
			list = service.bankView(gp, user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 model.addAttribute("list", list);
		 return "bankview";
	}
		

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String postStudentData(Model model, @Valid @ModelAttribute Registration reg, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		try {
			service.Register(reg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text = "Hey " + reg.getUserid() + " Welcome";
		model.addAttribute("message", text);
		return "success";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getDetails(Model model, @Valid @ModelAttribute Login log, BindingResult bindingResult,
			@ModelAttribute SessionListener listen, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (bindingResult.hasErrors()) {
			return "login";
		}

		String user = log.getUserid();
		String pass = log.getPassword();
		System.out.println(user);
		System.out.println(pass);
		String var2 = service.validation(log);
		listen.session = request.getSession(true);
		System.out.println(request.getSession(true).getId());
		HttpSessionEvent event = new HttpSessionEvent(listen.session);
		listen.sessionCreated(event);
		listen.session.setAttribute("attr", user);
		// request.getSession().setMaxInactiveInterval(100);
		model.addAttribute("loginsuccess", var2);
		return "success-login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, @ModelAttribute SessionListener listen, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		listen.session = request.getSession(false);
		System.out.println(request.getSession(false).getId());
		listen.session.invalidate();
		System.out.println(listen.session.getId());
		HttpSessionEvent event = new HttpSessionEvent(listen.session);
		listen.sessionDestroyed(event);
		String str = "You have been successfully logged out";
		model.addAttribute("message", str);
		return "Logout";
	}

	@RequestMapping(value = "/bank", method = RequestMethod.POST)
	public String getBankDetails(Model model, @Valid @ModelAttribute StoreBankDetails sbd,
			@ModelAttribute SessionListener listen, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		listen.session = request.getSession(true);
		HttpSessionEvent event = new HttpSessionEvent(listen.session);
		String user = (String) listen.session.getAttribute("attr");
		try {
			service.storeBank(sbd, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text = "Your Account details have been Stored";
		model.addAttribute("banksucess", text);
		return "final-success";
	}


	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteTeam(@PathVariable Integer id, Model model) {
		service.deleteTeam(id);
		model.addAttribute("message","Team with "+id +"successfully deleted.");
		return "homePage";
	}

	
}
