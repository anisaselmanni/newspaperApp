package com.example.newspaperapp.controllers;

import com.example.newspaperapp.dtos.article.ArticleDto;
import com.example.newspaperapp.dtos.article.CreateArticleRequest;
import com.example.newspaperapp.dtos.article.UpdateArticleRequest;
import com.example.newspaperapp.dtos.journalist.CreateJournalistRequest;
import com.example.newspaperapp.dtos.journalist.JournalistDto;
import com.example.newspaperapp.dtos.journalist.UpdateJournalistRequest;
import com.example.newspaperapp.services.JournalistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/journalists")
@RequiredArgsConstructor
@Validated
public class JournalistController {
    private final JournalistService service;

    @GetMapping
    public ResponseEntity<List<JournalistDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalistDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<JournalistDto> create(@Valid @RequestBody CreateJournalistRequest request) {
        var createdJournalist = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJournalist);
    }

   @PutMapping("/{id}")
    public ResponseEntity<JournalistDto> update(@PathVariable Integer id, @Valid @RequestBody UpdateJournalistRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
