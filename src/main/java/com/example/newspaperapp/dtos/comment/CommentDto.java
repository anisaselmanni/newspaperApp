package com.example.newspaperapp.dtos.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private String content;
    private Long userId;
    private String userFullName;
    private Long articleId;
    private Instant postedAt;
}
