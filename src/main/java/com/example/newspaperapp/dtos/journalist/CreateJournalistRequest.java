package com.example.newspaperapp.dtos.journalist;

import com.example.newspaperapp.entities.Article;
import com.example.newspaperapp.entities.Role;
import com.example.newspaperapp.entities.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateJournalistRequest {
    private User user;
    private String firstName;
    private String lastName;
    private String bio;
    private String email;
    private String password;
    private String profilePictureURL;
    private Instant joinedAt;


}
