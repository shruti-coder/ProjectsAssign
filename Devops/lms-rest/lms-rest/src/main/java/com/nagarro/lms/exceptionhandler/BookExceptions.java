package com.nagarro.lms.exceptionhandler;

import com.nagarro.lms.exception.BookNotFoundException;
import com.nagarro.lms.model.BookResponseError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptions {

    @Autowired
    BookResponseError error;

    @ExceptionHandler
    public ResponseEntity<BookResponseError> handleException(BookNotFoundException exception) {
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BookResponseError> handleException(Exception exception){
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Invalid request");
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
