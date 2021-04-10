package com.figsandwich.blog.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {

	String writeMsg(Map<String, String> msgMap);

}
