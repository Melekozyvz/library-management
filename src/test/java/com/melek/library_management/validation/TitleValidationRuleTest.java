package com.melek.library_management.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.melek.library_management.business.concrete.validation.TitleValidationRule;
import com.melek.library_management.dataAccess.BookRepository;
import com.melek.library_management.entity.Book;

@ExtendWith(MockitoExtension.class)
public class TitleValidationRuleTest {

	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private TitleValidationRule titleValidationRule;
	
	@Test
	void shouldThrowException_whenSameTitleExists() {
		//given
		Book book=new Book("Clean Code","Robert Martin","123","aaaabbbbbbbccccddddeeeee");
		when(bookRepository.existsByTitle(book.getTitle())).thenReturn(true);
		
		//then
		assertThrows(RuntimeException.class, ()-> titleValidationRule.validate(book));
		
		
	}
	@Test
	void shouldPass_whenNoSameTitleExists() {
		//given 
		Book book=new Book("Clean Code","Robert Martin","123","aaaabbbbbbbccccddddeeeee");

		when(bookRepository.existsByContent(book.getTitle())).thenReturn(false);
		
		//then
		assertDoesNotThrow(()->titleValidationRule.validate(book));
	}

}
