package com.nagarro.lms.controller;

import com.nagarro.lms.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nagarro.lms.service.BookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooksList() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{code}")
    public Book getBook(@PathVariable("code") String code) {
        return bookService.getBook(code);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/books")
    public Book update(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/books/{code}")
    public String deleteBook(@PathVariable String code) {
        bookService.deleteBook(code);
        return "Deleted: " + code;
    }

}
