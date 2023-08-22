package com.nagarro.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.lms.model.Author;
import com.nagarro.lms.model.AuthorDTO;
import com.nagarro.lms.service.AuthorService;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @GetMapping("/authors")
    public List<Author> getAuthorList(){
        return authorService.getAuthors();
    }

    @GetMapping("/authors/{authorID}")
    public Author getAuthor(@PathVariable("authorID") int authorID){
        return authorService.getAuthor(authorID);
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody AuthorDTO authordto) {
        return authorService.addAuthor(authordto.convertAuthorDtoToAuthor());
    }

    @DeleteMapping("/authors/{authorID}")
    public String deleteAuthor(@PathVariable String authorID) {
        authorService.deleteAuthor(Integer.parseInt(authorID));
        return "Deleted: " + authorID;
    }

}
