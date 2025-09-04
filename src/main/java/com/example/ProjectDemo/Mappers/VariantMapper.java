package com.example.ProjectDemo.Mappers;


import com.example.ProjectDemo.DTO.VariantDTO;
import com.example.ProjectDemo.Models.Variant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VariantMapper {
    @Mapping(source = "productId", target = "product.id")
    Variant toEntity(VariantDTO dto);

    @Mapping(source = "product.id", target = "productId")
    VariantDTO toResponseDTO(Variant entity);
}
