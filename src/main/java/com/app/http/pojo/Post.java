package com.app.http.pojo;

import lombok.Data;

@Data
public class Post {

	private Long id;
	private Long userId;
	private String title;
	private String body;
	
}
