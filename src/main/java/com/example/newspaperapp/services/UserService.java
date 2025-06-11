package com.example.newspaperapp.services;

import com.example.newspaperapp.dtos.user.CreateUserRequest;
import com.example.newspaperapp.dtos.user.UpdateUserRequest;
import com.example.newspaperapp.dtos.user.UserDto;


import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto create(CreateUserRequest request);
    UserDto update(long id, UpdateUserRequest request);
    void delete(Long id);
}
