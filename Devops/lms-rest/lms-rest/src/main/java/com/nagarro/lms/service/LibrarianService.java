package com.nagarro.lms.service;

import com.nagarro.lms.model.Librarian;

public interface LibrarianService {
    Librarian getLibrarian(String userName);

    Librarian addLibrarian(Librarian librarian);

    Librarian updateLibrarian(Librarian newLibrarian);
}
