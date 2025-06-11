package com.example.newspaperapp.mappers;

import com.example.newspaperapp.dtos.article.ArticleDto;
import com.example.newspaperapp.dtos.article.CreateArticleRequest;
import com.example.newspaperapp.dtos.article.UpdateArticleRequest;
import com.example.newspaperapp.entities.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleMapper {

    ArticleDto toDto(Article article);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "publishedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "journalist", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Article toEntity(ArticleDto articleDto);

    void updateEntityFromDto(UpdateArticleRequest updateDto, @MappingTarget Article article);

}
