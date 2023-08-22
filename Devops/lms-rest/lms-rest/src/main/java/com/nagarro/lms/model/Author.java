package com.nagarro.lms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    int authorID;
    String authorName;

    public Author() {
    }

    public Author(int authorID, String authorName) {
        this.authorID = authorID;
        this.authorName = authorName;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
