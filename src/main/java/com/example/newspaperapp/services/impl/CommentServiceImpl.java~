package com.example.newspaperapp.services.impl;

import com.example.newspaperapp.dtos.comment.CommentDto;
import com.example.newspaperapp.dtos.comment.CreateCommentRequest;
import com.example.newspaperapp.dtos.comment.UpdateCommentRequest;
import com.example.newspaperapp.entities.Comment;
import com.example.newspaperapp.exceptions.CommentNotFoundException;
import com.example.newspaperapp.mappers.ArticleMapper;
import com.example.newspaperapp.mappers.CommentMapper;
import com.example.newspaperapp.repositories.CommentRepository;
import com.example.newspaperapp.services.ArticleService;
import com.example.newspaperapp.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;
    private final CommentMapper commentMapper;
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @Override
    public List<CommentDto> findAllByArticleId(Long articleId) {
        if (articleId != null) {
            var articleDto = articleService.findById(articleId);
            var article = articleMapper.toEntity(articleDto);
            return repository.findAllByArticle(article)
                    .stream()
                    .map(commentMapper::toDto)
                    .toList();
        } else {
            return repository.findAll()
                    .stream()
                    .map(commentMapper::toDto)
                    .toList();
        }
    }

    @Override
    public CommentDto create(CreateCommentRequest request) {
        var comment = new Comment();
         comment.setArticle(request.getArticle());
         comment.setContent(request.getContent());


        var article = articleMapper.toEntity(articleService.findById(request.getArticleId()));
        comment.setArticle(article);

        comment.setPostedAt(request.getArticle().getPublishedAt());
        comment.setUser(request.getUser());

        var createdComment = repository.save(comment);
        return commentMapper.toDto(createdComment);
    }

    @Override
    public CommentDto update(long id, UpdateCommentRequest request) {
        var commentFromDb = repository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException(id));

        if (!commentFromDb.getId().equals(request.getId())) {
            throw new CommentNotFoundException(id);
        }
        commentFromDb.setContent(request.getContent());

        var updatedComment = repository.save(commentFromDb);
        return commentMapper.toDto(updatedComment);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException(id));
        repository.deleteById(id);

    }
}
