package com.nagarro.lms.service;

import com.nagarro.lms.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();

    Author getAuthor(int authorID);

    Author addAuthor(Author author);


    void deleteAuthor(int authorID);
}
