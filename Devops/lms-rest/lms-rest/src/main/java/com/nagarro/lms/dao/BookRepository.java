package com.nagarro.lms.dao;

import com.nagarro.lms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> { }
