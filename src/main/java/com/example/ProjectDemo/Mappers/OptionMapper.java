package com.example.ProjectDemo.Mappers;

import com.example.ProjectDemo.DTO.OptionDTO;
import com.example.ProjectDemo.Models.Option;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OptionValueMapper.class})
public interface OptionMapper {
    @Mapping(source = "productId", target = "product.id")
    Option toEntity(OptionDTO dto);

    @Mapping(source = "product.id", target = "productId")
    OptionDTO toResponseDTO(Option entity);
}
