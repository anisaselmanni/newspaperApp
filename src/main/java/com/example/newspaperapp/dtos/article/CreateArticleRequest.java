package com.example.newspaperapp.dtos.article;

import com.example.newspaperapp.entities.Category;
import com.example.newspaperapp.entities.Journalist;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateArticleRequest {
    private String title;
    private String content;
    private Category category;
    private String thumbnailURL;
    private Long journalistId;
    private Journalist journalist;

}
