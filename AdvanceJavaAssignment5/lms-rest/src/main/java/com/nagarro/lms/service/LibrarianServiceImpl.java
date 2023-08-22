package com.nagarro.lms.service;

import com.nagarro.lms.dao.LibrarianRepository;
import com.nagarro.lms.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class LibrarianServiceImpl implements LibrarianService{
    @Autowired
    LibrarianRepository librarianRepository;

    @Override
    public Librarian getLibrarian(String userName) {
        Optional<Librarian> result=librarianRepository.findById(userName);

        if(result.isPresent()){
            return result.get();
        }else {
            return null;
        }
    }

    @Override
    public Librarian addLibrarian(@RequestBody Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    @Override
    public Librarian updateLibrarian(Librarian newLibrarian) {
        Librarian librarian=getLibrarian(newLibrarian.getUserName());
        librarian.setPassword(newLibrarian.getPassword());

        librarianRepository.save(librarian);
        return librarian;
    }
}
