package com.example.ProjectDemo.Mappers;


import com.example.ProjectDemo.DTO.ImageDTO;
import com.example.ProjectDemo.Models.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    Image toEntity(ImageDTO dto);
    ImageDTO toResponseDTO(Image entity);
}
