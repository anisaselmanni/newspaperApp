package com.example.newspaperapp.exceptions;

    public class CommentNotFoundException extends ResourceNotFoundException {
    public CommentNotFoundException(Long id) {
        super("Comment with id:" + id + "not found!");
    }
}
