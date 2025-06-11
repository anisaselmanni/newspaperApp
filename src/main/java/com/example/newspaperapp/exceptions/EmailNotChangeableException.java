package com.example.newspaperapp.exceptions;

public class EmailNotChangeableException extends RuntimeException {
    public EmailNotChangeableException() {
      super("Email cannot be changed");
    }
}
