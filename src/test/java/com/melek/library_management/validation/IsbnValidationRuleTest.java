package com.melek.library_management.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.melek.library_management.business.concrete.validation.IsbnValidationRule;
import com.melek.library_management.dataAccess.BookRepository;
import com.melek.library_management.entity.Book;

@ExtendWith(MockitoExtension.class)
public class IsbnValidationRuleTest {

	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private IsbnValidationRule isbnValidationRule;
	
	@Test
	void shouldThrowException_whenIsbnExists() {
		//given
		Book book=new Book("Clean Code","Robert Martin","123","aaaabbbbbbbccccddddeeeee");
		when(bookRepository.existsByIsbn(book.getIsbn())).thenReturn(true);
		
		//then
		assertThrows(RuntimeException.class, ()-> isbnValidationRule.validate(book));
		
		
	}
	
}
