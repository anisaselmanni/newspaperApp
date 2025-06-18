package com.example.newspaperapp.services;

import com.example.newspaperapp.dtos.article.ArticleDto;
import com.example.newspaperapp.dtos.article.CreateArticleRequest;
import com.example.newspaperapp.dtos.article.UpdateArticleRequest;


import java.util.List;

public interface ArticleService {
    List<ArticleDto> findAll();
    ArticleDto findById(Long id);
    ArticleDto create(CreateArticleRequest request);
    ArticleDto update(long id, UpdateArticleRequest request);
    void delete(Long id);
}
