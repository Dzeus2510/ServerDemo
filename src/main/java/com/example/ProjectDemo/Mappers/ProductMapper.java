package com.example.ProjectDemo.Mappers;

import com.example.ProjectDemo.DTO.RequestProductDTO;
import com.example.ProjectDemo.DTO.ResponseProductDTO;
import com.example.ProjectDemo.Models.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(RequestProductDTO dto);

    ResponseProductDTO toResponseDTO(Product product);

    // Update entity từ RequestDTO (dùng cho PUT)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(RequestProductDTO dto, @MappingTarget Product product);
}
