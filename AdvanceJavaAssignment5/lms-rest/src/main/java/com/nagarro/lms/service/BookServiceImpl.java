package com.nagarro.lms.service;

import com.nagarro.lms.dao.BookRepository;
import com.nagarro.lms.exception.BookNotFoundException;
import com.nagarro.lms.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(String code) {
        Optional<Book> result = bookRepository.findById(code);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new BookNotFoundException("Book not found: "+code);
        }
    }

    @Override
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(@RequestBody Book newBook) {
        Book theBook = getBook(newBook.getCode());
        theBook.setAuthor(newBook.getAuthor());
        theBook.setName(newBook.getName());

        bookRepository.save(theBook);

        return theBook;
    }

    @Override
    public void deleteBook(String code) {
        Book theBook = getBook(code);
        bookRepository.deleteById(theBook.getCode());
    }

}
