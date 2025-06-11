package com.example.newspaperapp.services.impl;

import com.example.newspaperapp.dtos.article.ArticleDto;
import com.example.newspaperapp.dtos.article.CreateArticleRequest;
import com.example.newspaperapp.dtos.article.UpdateArticleRequest;
import com.example.newspaperapp.entities.Article;
import com.example.newspaperapp.entities.Status;
import com.example.newspaperapp.exceptions.ArticleNotFoundException;
import com.example.newspaperapp.repositories.ArticleRepository;
import com.example.newspaperapp.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;

    @Override
    public List<ArticleDto> findAll() {
        return repository.findAll()
                .stream()
                .map(article -> new ArticleDto(article.getTitle(), article.getContent(),article.getCategory(),article.getThumbnailURL(),article.getStatus(),article.getJournalist().getFirstName(), article.getPublishedAt()))
                .toList();
    }

    @Override
    public ArticleDto findById(Long id) {
        return repository.findById(id)
                .map(article -> new ArticleDto(article.getTitle(), article.getContent(),article.getCategory(),article.getThumbnailURL(),article.getStatus(),article.getJournalist().getFirstName(), article.getPublishedAt()))
                .orElseThrow(() -> new ArticleNotFoundException(id));
    }

    @Override
    public ArticleDto create(CreateArticleRequest request) {
        var articleToCreate = new Article(Long.valueOf(0),request.getTitle(), request.getContent(),request.getCategory(),request.getJournalist(),request.getThumbnailURL(), Instant.now(), Status.DRAFT,new ArrayList<>());
        var createdArticle = repository.save(articleToCreate);
        return new ArticleDto(createdArticle.getTitle(), createdArticle.getContent(),createdArticle.getCategory(),createdArticle.getThumbnailURL(),createdArticle.getStatus(),createdArticle.getJournalist().getFirstName(), createdArticle.getPublishedAt());
    }

    @Override
    public ArticleDto update(long id, UpdateArticleRequest request) {
         var articleFromDb = repository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
         if (!articleFromDb.getTitle().equals(request.getTitle())) {

         }
         articleFromDb.setTitle(request.getTitle());
             articleFromDb.setContent(request.getContent());
             articleFromDb.setCategory(request.getCategory());
             articleFromDb.setThumbnailURL(request.getThumbnailURL());
             articleFromDb.setPublishedAt(Instant.now());
   var updatedArticle = repository.save(articleFromDb);
        return new ArticleDto(updatedArticle.getTitle(), updatedArticle.getContent(), updatedArticle.getCategory(), updatedArticle.getThumbnailURL(), updatedArticle.getStatus(), updatedArticle.getJournalist().getFirstName(), updatedArticle.getPublishedAt());
    }


    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
        repository.deleteById(id);
    }
}
