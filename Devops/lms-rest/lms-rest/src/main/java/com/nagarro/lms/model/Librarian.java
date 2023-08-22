package com.nagarro.lms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Librarian {

    @Id
    private String userName;
    private String password;

    public Librarian(){}

    public Librarian(String userId, String password) {
        this.userName = userId;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
