package com.figsandwich.blog.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.figsandwich.blog.dto.BlogVO;
import com.figsandwich.blog.mapper.BlogMapper;

@Service
public class BlogService {

	@Autowired
	BlogMapper blogMapper;
	public String writeMsg(Map<String, String> msgMap) {
		
		
		return blogMapper.writeMsg(msgMap);
		// TODO Auto-generated method stub
		
	}

}
