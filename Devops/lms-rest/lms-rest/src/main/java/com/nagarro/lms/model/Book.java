package com.nagarro.lms.model;

import org.springframework.stereotype.Component;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Component
public class Book {
    @Id
    private String code;
    private String name;
    private String author;
    private String date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
