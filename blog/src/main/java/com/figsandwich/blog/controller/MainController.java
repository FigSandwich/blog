package com.figsandwich.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.figsandwich.blog.service.BlogService;

@Controller
public class MainController {

	@Autowired
	BlogService blogService;

	@RequestMapping("/")
	public String MainPage() {
		return "thymeleaf/index";
	}

	@RequestMapping("/test")
	public ModelAndView test() throws Exception {
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("name", "jhpark");
		List<String> testList = new ArrayList<String>();
		testList.add("a");
		mav.addObject("list", testList);
		return mav;
	}

}
