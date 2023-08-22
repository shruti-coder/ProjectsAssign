package com.nagarro.lms.model;

public class AuthorDTO {
    int authorID;
    String authorName;

    public AuthorDTO() {
    }

    public AuthorDTO(int authorID, String authorName) {
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

    public Author convertAuthorDtoToAuthor() {
    	Author author=new Author();
    	author.setAuthorID(this.getAuthorID());
    	author.setAuthorName(this.getAuthorName());
    	return author;
    }
    
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
