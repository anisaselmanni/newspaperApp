package com.example.newspaperapp.controllers;

import com.example.newspaperapp.dtos.journalist.CreateJournalistRequest;
import com.example.newspaperapp.dtos.journalist.JournalistDto;
import com.example.newspaperapp.dtos.journalist.UpdateJournalistRequest;
import com.example.newspaperapp.dtos.user.CreateUserRequest;
import com.example.newspaperapp.dtos.user.UpdateUserRequest;
import com.example.newspaperapp.dtos.user.UserDto;
import com.example.newspaperapp.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService service;

        @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody CreateUserRequest request) {
        var createdJournalist = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJournalist);
    }

   @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Integer id, @Valid @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


