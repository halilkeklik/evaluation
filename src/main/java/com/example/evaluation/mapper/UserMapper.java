package com.example.evaluation.mapper;
import com.example.evaluation.dtos.UserDto;
import com.example.evaluation.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    User toEntity(UserDto dto);
}
