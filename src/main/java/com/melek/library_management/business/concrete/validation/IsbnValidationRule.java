package com.melek.library_management.business.concrete.validation;

import com.melek.library_management.business.abstracts.BookValidationRule;
import com.melek.library_management.dataAccess.BookRepository;
import com.melek.library_management.entity.Book;

public class IsbnValidationRule implements BookValidationRule {

	private final BookRepository bookRepository;
	
	public IsbnValidationRule(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	@Override
	public void validate(Book book) {
		if(bookRepository.existsByIsbn(book.getIsbn())) {
			throw new RuntimeException("ISBN zaten mevcut");
		}
		
	}

}
