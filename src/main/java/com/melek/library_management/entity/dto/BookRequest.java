package com.melek.library_management.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class BookRequest {

	private String title;
	private String author;
	private String isbn;
	private String content;
	
}
