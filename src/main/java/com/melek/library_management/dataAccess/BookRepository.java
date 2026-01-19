package com.melek.library_management.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melek.library_management.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	boolean existsByTitle(String title);
	
	boolean existsByContent(String content);
	
	boolean existsByIsbn(String isbn);

}
