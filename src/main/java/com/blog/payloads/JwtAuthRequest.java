package com.blog.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {
	
	//email is the only username
	private String username;
	
	private String password;

}
