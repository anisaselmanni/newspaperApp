package com.example.newspaperapp.dtos.journalist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateJournalistRequest {
    private String firstName;
    private String lastName;
    private String password;
}
