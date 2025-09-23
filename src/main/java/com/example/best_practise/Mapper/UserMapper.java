package com.example.best_practise.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.example.best_practise.Entity.UserEntity;
import com.example.best_practise.dto.UserRequestDto;
import com.example.best_practise.dto.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface UserMapper {

  UserEntity toEntity(UserRequestDto userRequestDto);

  UserResponseDto toDto(UserEntity userEntity);
}
