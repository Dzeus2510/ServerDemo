package com.example.ProjectDemo.Mappers;

import com.example.ProjectDemo.DTO.OptionValueDTO;
import com.example.ProjectDemo.Models.OptionValue;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OptionValueMapper {
    OptionValue toEntity(OptionValueDTO dto);
    OptionValueDTO toResponseDTO(OptionValue entity);
}
