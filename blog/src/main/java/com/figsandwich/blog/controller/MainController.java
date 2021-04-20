package com.figsandwich.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.figsandwich.blog.dto.BlogVO;
import com.figsandwich.blog.service.BlogService;

@Controller
public class MainController {

	@Autowired
	BlogService blogService;

	@GetMapping("/")
	public String MainPage(Model model) {

		model.addAttribute("list", blogService.viewMessage());
		return "thymeleaf/index";
	}

	@PostMapping(path = "/write")
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
			return "thymeleaf/index";
		} else {
			return "thymeleaf/index";

		}

	}



	@GetMapping("/msgtest")
	public String TestPage(Model model) {
		// model.addAttribute("list",blogService.viewMessage());
		model.addAttribute("list", blogService.viewMessage());

		return "thymeleaf/test";
	}
	
	@GetMapping("/delete/{mno}")
	public String deletePage(HttpServletRequest request,
			@PathVariable(name = "mno", required = true) int mno){		
		blogService.delMsg(mno);
		return "redirect:/";
	}
	
	
	
	/*
	 * @RequestMapping("/test") public ModelAndView test() throws Exception {
	 * ModelAndView mav = new ModelAndView("test"); mav.addObject("name", "jhpark");
	 * List<String> testList = new ArrayList<String>(); testList.add("a");
	 * mav.addObject("list", testList); return mav; }
	 */

}
