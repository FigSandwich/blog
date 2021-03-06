package com.figsandwich.blog.service;

import java.util.List;
import java.util.Map;

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

	public List<BlogVO> viewMessage() {
		// TODO Auto-generated method stub
		return blogMapper.viewMessage();
	}

	public String chkPW(int msgNo) {
		// TODO Auto-generated method stub
		return blogMapper.chkPW(msgNo);
	}

	public void delMsg(int msgno) {
		// TODO Auto-generated method stub
		blogMapper.delMsg(msgno);
		
	}

}
