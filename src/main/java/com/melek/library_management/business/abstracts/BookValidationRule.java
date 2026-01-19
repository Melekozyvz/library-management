package com.melek.library_management.business.abstracts;

import com.melek.library_management.entity.Book;

public interface BookValidationRule {

	void validate(Book book);
}
