package com.example.newspaperapp.dtos.user;

import com.example.newspaperapp.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Instant updatedAt;
    private Role role;
}
