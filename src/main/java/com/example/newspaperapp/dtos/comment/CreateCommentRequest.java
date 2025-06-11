package com.example.newspaperapp.dtos.comment;

import com.example.newspaperapp.entities.Article;
import com.example.newspaperapp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentRequest {
    private String content;
    private User user;
    private Long userId;
    private Article article;
    private Long articleId;
}
