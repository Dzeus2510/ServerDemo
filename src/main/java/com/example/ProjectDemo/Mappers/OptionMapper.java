package com.example.ProjectDemo.Mappers;

import com.example.ProjectDemo.DTO.OptionDTO;
import com.example.ProjectDemo.Models.Option;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OptionValueMapper.class})
public interface OptionMapper {
    Option toEntity(OptionDTO dto);
    OptionDTO toResponseDTO(Option entity);
}
