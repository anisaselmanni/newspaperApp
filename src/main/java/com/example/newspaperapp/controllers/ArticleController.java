package com.example.newspaperapp.controllers;

import com.example.newspaperapp.dtos.article.ArticleDto;
import com.example.newspaperapp.dtos.article.CreateArticleRequest;
import com.example.newspaperapp.dtos.article.UpdateArticleRequest;
import com.example.newspaperapp.services.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
@Validated
public class ArticleController {
    private final ArticleService service;

    @GetMapping
    public ResponseEntity<List<ArticleDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ArticleDto> create(@Valid @RequestBody CreateArticleRequest request) {
        var createdArticle = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
    }

   @PutMapping("/{id}")
    public ResponseEntity<ArticleDto> update(@PathVariable Long id, @Valid @RequestBody UpdateArticleRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
