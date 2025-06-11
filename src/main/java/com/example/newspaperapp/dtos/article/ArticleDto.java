package com.example.newspaperapp.dtos.article;

import com.example.newspaperapp.entities.Category;
import com.example.newspaperapp.entities.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private String title;
    private String content;
    private Category category;
    private String thumbnailURL;
    private Status status;
    private String journalistFullName;
    private Instant publishedAt;
}
