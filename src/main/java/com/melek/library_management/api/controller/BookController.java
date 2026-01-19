package com.melek.library_management.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melek.library_management.business.abstracts.BookService;
import com.melek.library_management.entity.dto.BookRequest;

@RestController
@RequestMapping("/api/book/")
public class BookController {

	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	@PostMapping
	public ResponseEntity saveBook(@RequestBody BookRequest request) {
		
		return ResponseEntity.ok(this.bookService.saveBook(request));
		
	}
	@GetMapping("getall")
	public ResponseEntity getall() {
		return ResponseEntity.ok(this.bookService.getall());
	}
}
