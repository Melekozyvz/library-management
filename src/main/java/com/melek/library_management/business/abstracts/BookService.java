package com.melek.library_management.business.abstracts;

import java.util.List;

import com.melek.library_management.entity.Book;
import com.melek.library_management.entity.dto.BookRequest;

public interface BookService {

	boolean saveBook(BookRequest request);
	
	List<Book> getall();
}
