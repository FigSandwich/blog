package com.figsandwich.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.figsandwich.blog.dto.BlogVO;
import com.figsandwich.blog.service.BlogService;

@Controller
public class MainController {

	@Autowired
	BlogService blogService;

	@RequestMapping("/")
	public String MainPage(Model model) {

		model.addAttribute("list", blogService.viewMessage());
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

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public RedirectView delMsg(@ModelAttribute BlogVO blogVo) {

		String orignPw = blogService.chkPW(blogVo.getMsgno());
		String recvPw = blogVo.getPw();
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/");

		try {
			if (orignPw.equals(recvPw)) {
				blogService.delMsg(blogVo.getMsgno());
				redirectView.setUrl("/");
				
			} 

		} catch (Exception e) {
			// TODO: handle exception
			redirectView.setUrl("/delmsg");
			return redirectView;
			
			
		}
		return redirectView;
		

		
	}

	@RequestMapping("/list")
	public String msgList(Model model) {
		model.addAttribute("list", blogService.viewMessage());
		return "thymeleaf/list";

	}

	@RequestMapping("/delmsg")
	public String TestPage(Model model) {
		// model.addAttribute("list",blogService.viewMessage());

		return "thymeleaf/test";
	}

	/*
	 * @RequestMapping("/test") public ModelAndView test() throws Exception {
	 * ModelAndView mav = new ModelAndView("test"); mav.addObject("name", "jhpark");
	 * List<String> testList = new ArrayList<String>(); testList.add("a");
	 * mav.addObject("list", testList); return mav; }
	 */

}
