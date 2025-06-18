package com.example.newspaperapp.repositories;

import com.example.newspaperapp.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
