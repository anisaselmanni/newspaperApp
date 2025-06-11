package com.example.newspaperapp.mappers;

import com.example.newspaperapp.dtos.user.UserDto;
import com.example.newspaperapp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "journalist", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt" , ignore = true)
    @Mapping(target = "createdBy" , ignore = true)
    @Mapping(target = "updatedAt" , ignore = true)
    User toEntity(UserDto userDto);
}
