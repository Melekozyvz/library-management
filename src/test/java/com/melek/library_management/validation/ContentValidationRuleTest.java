package com.melek.library_management.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.melek.library_management.business.concrete.validation.ContentValidationRule;
import com.melek.library_management.dataAccess.BookRepository;
import com.melek.library_management.entity.Book;

@ExtendWith(MockitoExtension.class)
public class ContentValidationRuleTest {

	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private ContentValidationRule contentValidationRule;
	
	@Test
	void shouldThrowException_whenSamecontentExists() {
		//given
		Book book=new Book("Clean Code","Robert Martin","123","aaaabbbbbbbccccddddeeeee");
		when(bookRepository.existsByContent(book.getContent())).thenReturn(true);
		
		//then
		assertThrows(RuntimeException.class, ()-> contentValidationRule.validate(book));
		
		
	}
	@Test
	void shouldPass_whenNoSameContentExists() {
		//given 
		Book book=new Book("Clean Code","Robert Martin","123","aaaabbbbbbbccccddddeeeee");

		when(bookRepository.existsByContent(book.getContent())).thenReturn(false);
		
		//then
		assertDoesNotThrow(()->contentValidationRule.validate(book));
	}
}
