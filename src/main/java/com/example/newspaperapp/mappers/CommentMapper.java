package com.example.newspaperapp.mappers;

import com.example.newspaperapp.dtos.comment.CommentDto;
import com.example.newspaperapp.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    CommentDto toDto(Comment comment);
    Comment toEntity(CommentDto commentDto);

}
