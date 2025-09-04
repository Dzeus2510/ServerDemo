package com.example.ProjectDemo.Mappers;

import com.example.ProjectDemo.DTO.OptionValueDTO;
import com.example.ProjectDemo.Models.OptionValue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OptionValueMapper {
    @Mapping(source = "optionId", target = "option.id")
    OptionValue toEntity(OptionValueDTO dto);

    @Mapping(source = "option.id", target = "optionId")
    OptionValueDTO toResponseDTO(OptionValue entity);
}
