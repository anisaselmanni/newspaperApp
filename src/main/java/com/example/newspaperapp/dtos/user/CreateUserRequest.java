package com.example.newspaperapp.dtos.user;

import com.example.newspaperapp.entities.Journalist;
import com.example.newspaperapp.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;
    private Boolean isActive;
    private Long createdBy;
    private Instant createdAt;
    private Journalist journalist;
    private Instant updatedAt;


}
