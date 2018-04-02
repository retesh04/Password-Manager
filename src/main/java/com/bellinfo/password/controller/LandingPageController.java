package com.bellinfo.password.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LandingPageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landingPage(Model model) {
		return "login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexPage(Model model) {
		return "login";
	}

}
