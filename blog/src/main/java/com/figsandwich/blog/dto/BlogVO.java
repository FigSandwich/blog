package com.figsandwich.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlogVO {
	private Integer msgno;
	private String name;
	private String pw;
	// String email;
	private String phone;
	private String message;

	
	public String checkNull() {
		if (name ==null) {
			return "1";
		}else if(pw ==null) {
			return "1";
		}else if (phone ==null) {
			return "1";
		}else if(message == null) {
			return "1";
		}else {
			return "0";
		}
		
		
	}
	
	
	
}
