package com.example.newspaperapp.exceptions;

public class UserNotFoundException extends ResourceNotFoundException {
  public UserNotFoundException(Long id) {
    super("User with id:" + id + "not found!");
  }
}