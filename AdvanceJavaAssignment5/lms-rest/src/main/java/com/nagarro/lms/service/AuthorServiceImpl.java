package com.nagarro.lms.service;

import com.nagarro.lms.dao.AuthorRepository;

import com.nagarro.lms.model.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthor(int authorID) {
        Optional<Author> result = authorRepository.findById(authorID);

        return result.orElse(null);
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }


    @Override
    public void deleteAuthor(int authorID) {
        authorRepository.deleteById(authorID);
    }
}
