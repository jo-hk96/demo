package com.example.demo.dto;

import lombok.Data;

@Data
public class Member {
	private long id;
	private String name;
	private String email;
	private String password;
	public Member(long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	

}
