package com.example.best_practise.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.example.best_practise.Entity.PcEntity;
import com.example.best_practise.dto.PcRequestDto;
import com.example.best_practise.dto.PcResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface PcMapper {

  PcEntity toEntity(PcRequestDto pcRequestDto);

  PcResponseDto toDto(PcEntity pcEntity);

}
