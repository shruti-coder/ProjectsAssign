package com.nagarro.lms.service;

import com.nagarro.lms.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBook(String code);

    Book addBook(Book book);

    Book updateBook(Book newBook);

    void deleteBook(String code);
}
