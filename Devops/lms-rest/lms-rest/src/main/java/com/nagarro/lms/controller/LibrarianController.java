package com.nagarro.lms.controller;

import com.nagarro.lms.model.Librarian;
import com.nagarro.lms.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibrarianController {
    @Autowired
    private LibrarianService librarianService;

    @GetMapping("/librarians/{userName}")
    public Librarian getLibrarian(@PathVariable String userName){
        return librarianService.getLibrarian(userName);
    }

    @PostMapping("/librarians")
    public Librarian addLibrarian(@RequestBody Librarian librarian){
        return librarianService.addLibrarian(librarian);
    }

    @PutMapping("/librarians")
    public Librarian updateLibrarian(@RequestBody Librarian librarian){
        return librarianService.updateLibrarian(librarian);
    }
}
