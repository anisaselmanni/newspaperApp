package com.example.newspaperapp.exceptions;

public class JournalistNotFoundException extends ResourceNotFoundException {
    public JournalistNotFoundException(Long id) {
        super("Journalist with id:" + id + "not found!");
    }
}