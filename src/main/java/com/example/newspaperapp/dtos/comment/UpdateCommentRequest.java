package com.example.newspaperapp.dtos.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCommentRequest {
    private Long id;
    private String content;
}
