package com.example.newspaperapp.repositories;

import com.example.newspaperapp.entities.Article;
import com.example.newspaperapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByArticle(Article article);
}
