package com.melek.library_management.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melek.library_management.business.abstracts.BookService;
import com.melek.library_management.business.abstracts.BookValidationRule;
import com.melek.library_management.dataAccess.BookRepository;
import com.melek.library_management.entity.Book;
import com.melek.library_management.entity.dto.BookRequest;

@Service
public class BookManager implements BookService{


	private final List<BookValidationRule> rules;
	private BookRepository bookRepository;
	
	@Autowired
	public BookManager(BookRepository bookRepository,List<BookValidationRule> rules) {
		this.bookRepository=bookRepository;
		this.rules=rules;
	}
	@Override
	public boolean saveBook(BookRequest request) {
		Book book=new Book();
		book.setTitle(request.getTitle());
		book.setAuthor(request.getAuthor());
		book.setIsbn(request.getIsbn());
		book.setContent(request.getContent());
		rules.forEach(rule->rule.validate(book));
		Book savedBook=bookRepository.save(book);
		if (savedBook==null) {
			return false;

		}
		return true;
	}
	
	@Override
	public List<Book> getall() {
		
		return this.bookRepository.findAll();
	}

}
