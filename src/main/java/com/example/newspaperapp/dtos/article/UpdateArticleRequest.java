package com.example.newspaperapp.dtos.article;

import com.example.newspaperapp.entities.Category;
import com.example.newspaperapp.entities.Status;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateArticleRequest {
    private String title;
    private String content;
    private Category category;
    private String thumbnailURL;
    private Long journalistId;
    private Status status;
}
