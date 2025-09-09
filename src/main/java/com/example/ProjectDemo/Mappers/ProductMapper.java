package com.example.ProjectDemo.Mappers;

import com.example.ProjectDemo.DTO.RequestProductDTO;
import com.example.ProjectDemo.DTO.ResponseProductDTO;
import com.example.ProjectDemo.Models.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ImageMapper.class, OptionMapper.class, VariantMapper.class, OptionValueMapper.class})
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    Product toEntity(RequestProductDTO dto);

    ResponseProductDTO toResponseDTO(Product product);

    // Update entity từ RequestDTO (dùng cho PUT)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(RequestProductDTO dto, @MappingTarget Product product);
}
