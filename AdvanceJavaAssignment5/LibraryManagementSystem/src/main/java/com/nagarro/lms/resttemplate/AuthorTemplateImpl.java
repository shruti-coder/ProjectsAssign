package com.nagarro.lms.resttemplate;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.lms.model.Author;

@Component
public class AuthorTemplateImpl implements AuthorTemplate {

    @Autowired
    private RestTemplate restTemplate;

    private final String ROOT_URL = "http://localhost:8070/lms/authors";

    @Override
    public List<Author> getAuthors() {
        ResponseEntity<Author[]> response = restTemplate.getForEntity(ROOT_URL,Author[].class);
        return Arrays.asList(response.getBody());
    }
}
