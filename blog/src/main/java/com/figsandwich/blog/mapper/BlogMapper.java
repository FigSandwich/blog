package com.figsandwich.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.figsandwich.blog.dto.BlogVO;

@Mapper
public interface BlogMapper {

	String writeMsg(Map<String, String> msgMap);

	List<BlogVO> viewMessage();

	String delMsg(int mno);

	List<BlogVO> msgDetail(int mno);

}
