package com.figsandwich.blog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.figsandwich.blog.dto.BlogVO;
import com.figsandwich.blog.service.BlogService;

@Controller
public class MainController {

	@Autowired
	BlogService blogService;

	@RequestMapping("/")
	public String MainPage(Model model) {
		
		model.addAttribute("list",blogService.viewMessage());
		return "thymeleaf/index";
	}

	@RequestMapping(path = "/write", method = RequestMethod.POST)
	public String writeMsg(@ModelAttribute BlogVO blogVo) {

		if (blogVo.checkNull().equals("0")) {
			Map<String, String> msgMap = new HashMap<String, String>();

			msgMap.put("NAME", blogVo.getName());
			msgMap.put("PW", blogVo.getPw());
			msgMap.put("PHONE", blogVo.getPhone());
			msgMap.put("MESSAGE", blogVo.getMessage());
			blogService.writeMsg(msgMap);
			return "thymeleaf/index";

		} else if (blogVo.checkNull().equals("1")) {
			System.out.println("null");
			return "thymeleaf/index";
		} else {
			System.out.println("null");
			return "thymeleaf/index";

		}

	}
	
	
	@RequestMapping("/list")
	public String msgList(Model model) {
		model.addAttribute("list",blogService.viewMessage());		
		return "thymeleaf/list";
		
	}

	@RequestMapping("/msgtest")
	public String TestPage(Model model) {				
		//model.addAttribute("list",blogService.viewMessage());		

		return "thymeleaf/test";
	}

	
	



	/*
	 * @RequestMapping("/test") public ModelAndView test() throws Exception {
	 * ModelAndView mav = new ModelAndView("test"); mav.addObject("name", "jhpark");
	 * List<String> testList = new ArrayList<String>(); testList.add("a");
	 * mav.addObject("list", testList); return mav; }
	 */

}
