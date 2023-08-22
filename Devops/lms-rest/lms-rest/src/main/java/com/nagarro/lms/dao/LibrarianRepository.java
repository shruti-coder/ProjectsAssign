package com.nagarro.lms.dao;

import com.nagarro.lms.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian,String> {
}
