package com.example.newspaperapp.dtos.journalist;

import com.example.newspaperapp.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalistDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;
}
