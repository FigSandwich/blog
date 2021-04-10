package com.figsandwich.blog.mapper;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Mapper;

import com.figsandwich.blog.dto.BlogVO;

@Mapper
public interface BlogMapper {

	String writeMsg(Map<String, String> msgMap);

}
