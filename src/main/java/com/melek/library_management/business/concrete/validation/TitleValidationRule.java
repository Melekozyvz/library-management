package com.melek.library_management.business.concrete.validation;

import com.melek.library_management.business.abstracts.BookValidationRule;
import com.melek.library_management.dataAccess.BookRepository;
import com.melek.library_management.entity.Book;

public class TitleValidationRule implements BookValidationRule{

	private final BookRepository bookRepository;
	
	
	public TitleValidationRule(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	@Override
	public void validate(Book book) {
		if(bookRepository.existsByTitle(book.getTitle())) {
			throw new RuntimeException("Aynı başlıkta kitap zaten var");
		}
			
		
	}

}
