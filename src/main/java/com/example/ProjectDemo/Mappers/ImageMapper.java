package com.example.ProjectDemo.Mappers;


import com.example.ProjectDemo.DTO.ImageDTO;
import com.example.ProjectDemo.Models.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    @Mapping(source = "productId", target = "product.id")
    Image toEntity(ImageDTO dto);

    @Mapping(source = "product.id", target = "productId")
    ImageDTO toResponseDTO(Image entity);
}
