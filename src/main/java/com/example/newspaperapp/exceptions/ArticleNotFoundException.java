package com.example.newspaperapp.exceptions;

public class ArticleNotFoundException extends ResourceNotFoundException {
    public ArticleNotFoundException(Long id) {
        super("Article with id:" + id + "not found!");
    }
}
