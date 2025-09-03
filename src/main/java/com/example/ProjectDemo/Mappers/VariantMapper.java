package com.example.ProjectDemo.Mappers;


import com.example.ProjectDemo.DTO.VariantDTO;
import com.example.ProjectDemo.Models.Variant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VariantMapper {
    Variant toEntity(VariantDTO dto);
    VariantDTO toResponseDTO(Variant entity);
}
