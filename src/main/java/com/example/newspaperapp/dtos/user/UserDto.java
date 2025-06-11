package com.example.newspaperapp.dtos.user;

import com.example.newspaperapp.entities.Comment;
import com.example.newspaperapp.entities.Journalist;
import com.example.newspaperapp.entities.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String surname;
    private String email;
    private Role role;
    private Boolean isActive;
    private Long createdBy;
    private Instant createdAt;

}
