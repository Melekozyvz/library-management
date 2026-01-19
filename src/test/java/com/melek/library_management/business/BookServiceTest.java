package com.melek.library_management.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.melek.library_management.business.abstracts.BookService;
import com.melek.library_management.business.abstracts.BookValidationRule;
import com.melek.library_management.business.concrete.BookManager;
import com.melek.library_management.dataAccess.BookRepository;
import com.melek.library_management.entity.Book;
import com.melek.library_management.entity.dto.BookRequest;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	@Mock
	private BookRepository bookRepository;
	
	@Mock
	private BookValidationRule rule1;
	@Mock
	private BookValidationRule rule2;
	
	@Mock
	private BookValidationRule rule3;
	
	private BookService bookService;
	
	@Captor
	ArgumentCaptor<Book> bookCaptor;

	@BeforeEach
	void setUp() {
		bookService=new BookManager(bookRepository,List.of(rule1,rule2,rule3));
	}
	
	@Test
	void shouldValidateAllrules_beforeSaving() {
		BookRequest bookReq=new BookRequest("Clean Code","Robert Martin","123","aaaabbbbbbbccccddddeeeee");
		Book book=new Book("Clean Code","Robert Martin","123","aaaabbbbbbbccccddddeeeee");

		bookService.saveBook(bookReq);
		
		verify(rule1).validate(bookCaptor.capture());
		verify(rule2).validate(bookCaptor.capture());
		verify(rule3).validate(bookCaptor.capture());

	}
	
	@Test
	void shouldPassCorrectBookToRespository() {
		//given
		BookRequest request=new BookRequest("Clean Code","Robert Martin","123","aaaabbbbbbbccccddddeeeee");
		
		//when
		bookService.saveBook(request);
		
		//then
		verify(bookRepository).save(bookCaptor.capture());
		
		Book CapturedBook=bookCaptor.getValue();
		assertEquals("Clean Code", CapturedBook.getTitle());
		assertEquals("Robert Martin", CapturedBook.getAuthor());
		assertEquals("123", CapturedBook.getIsbn());
		assertEquals("aaaabbbbbbbccccddddeeeee", CapturedBook.getContent());


	}
}
