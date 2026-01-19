package com.melek.library_management.business.concrete.validation;

import com.melek.library_management.business.abstracts.BookValidationRule;
import com.melek.library_management.dataAccess.BookRepository;
import com.melek.library_management.entity.Book;

public class ContentValidationRule implements BookValidationRule {

	private final BookRepository bookRepository;
	
	public ContentValidationRule(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	@Override
	public void validate(Book book) {
		if(bookRepository.existsByContent(book.getContent())) {
			throw new RuntimeException("Aynı içerikte kitap zaten var");
		}
		
	}

}
