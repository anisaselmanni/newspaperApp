package com.example.newspaperapp.controllers;


import com.example.newspaperapp.dtos.comment.CommentDto;
import com.example.newspaperapp.dtos.comment.CreateCommentRequest;
import com.example.newspaperapp.dtos.comment.UpdateCommentRequest;
import com.example.newspaperapp.services.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;

    @GetMapping("article/{id}")
    public ResponseEntity<List<CommentDto>> findAllByArticleId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllByArticleId(id));
    }

    @PostMapping
    public ResponseEntity<CommentDto> create(@Valid @RequestBody CreateCommentRequest request) {
        var createdComment = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

   @PutMapping("/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Integer id, @Valid @RequestBody UpdateCommentRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
