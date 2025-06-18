package com.example.newspaperapp.services.impl;

import com.example.newspaperapp.dtos.user.CreateUserRequest;
import com.example.newspaperapp.dtos.user.UpdateUserRequest;
import com.example.newspaperapp.dtos.user.UserDto;
import com.example.newspaperapp.entities.User;
import com.example.newspaperapp.exceptions.UserNotFoundException;
import com.example.newspaperapp.mappers.UserMapper;
import com.example.newspaperapp.repositories.UserRepository;
import com.example.newspaperapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserDto> findAll() {
        return repository.findAll()
                .stream()
                .map(user -> new UserDto(user.getName(), user.getSurname(), user.getEmail(), user.getRole(),user.getIsActive(),user.getCreatedBy(),user.getCreatedAt()))
                .toList();
    }

    @Override
    public UserDto findById(Long id) {
        return repository.findById(id)
                .map(user -> new UserDto(user.getName(), user.getSurname(), user.getEmail(), user.getRole(),user.getIsActive(),user.getCreatedBy(),user.getCreatedAt()))
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found!"));
    }

    @Override
    public UserDto create(CreateUserRequest request) {
        var userToCreate = new User(0L,request.getName(), request.getSurname(), request.getEmail(),request.getPassword(), request.getRole(),request.getIsActive(),request.getCreatedBy(),request.getCreatedAt(),request.getJournalist(),new ArrayList<>(),request.getUpdatedAt());
        var createdUser = repository.save(userToCreate);
        return mapper.toDto(createdUser);
    }

    @Override
    public UserDto update(long id, UpdateUserRequest request) {
        var userFromDb = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userFromDb.setName(request.getName());
        userFromDb.setSurname(request.getSurname());
        userFromDb.setEmail(request.getEmail());
        userFromDb.setPassword(request.getPassword());
        userFromDb.setRole(request.getRole());
        userFromDb.setUpdatedAt(Instant.now());
        var updatedUser = repository.save(userFromDb);
        return mapper.toDto(updatedUser);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        repository.deleteById(id);
    }
}
