package com.example.ProjectDemo.Services;

import com.example.ProjectDemo.DTO.RequestProductDTO;
import com.example.ProjectDemo.DTO.ResponseProductDTO;
import com.example.ProjectDemo.Mappers.ProductMapper;
import com.example.ProjectDemo.Models.Product;
import com.example.ProjectDemo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    // Create
    public ResponseProductDTO createProduct(RequestProductDTO dto) {
        Product product = productMapper.toEntity(dto);
        product.setCreatedOn(new java.util.Date());
        Product saved = productRepository.save(product);
        return productMapper.toResponseDTO(saved);
    }

    // Get all
    public List<ResponseProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Get by id
    public Optional<ResponseProductDTO> getProductById(int id) {
        return productRepository.findById(id)
                .map(productMapper::toResponseDTO);
    }

    // Update
    public Optional<ResponseProductDTO> updateProduct(int id, RequestProductDTO dto) {
        return productRepository.findById(id).map(existing -> {
            productMapper.updateEntityFromDto(dto, existing);
            existing.setModifiedOn(new java.util.Date());
            Product updated = productRepository.save(existing);
            return productMapper.toResponseDTO(updated);
        });
    }

    // Delete
    public boolean deleteProduct(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
