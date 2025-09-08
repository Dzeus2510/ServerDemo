package com.example.ProjectDemo.Services;

import com.example.ProjectDemo.DTO.RequestProductDTO;
import com.example.ProjectDemo.DTO.ResponseProductDTO;
import com.example.ProjectDemo.Mappers.ProductMapper;
import com.example.ProjectDemo.Models.Image;
import com.example.ProjectDemo.Models.Option;
import com.example.ProjectDemo.Models.Product;
import com.example.ProjectDemo.Models.Variant;
import com.example.ProjectDemo.Repository.ImageRepository;
import com.example.ProjectDemo.Repository.OptionRepository;
import com.example.ProjectDemo.Repository.ProductRepository;
import com.example.ProjectDemo.Repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ImageRepository imageRepository;
    private final VariantRepository variantRepository;
    private final OptionRepository optionRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper, ImageRepository imageRepository, VariantRepository variantRepository,OptionRepository optionRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.imageRepository = imageRepository;
        this.variantRepository = variantRepository;
        this.optionRepository = optionRepository;
    }

    // Create
    @Transactional
    public ResponseProductDTO createProduct(RequestProductDTO dto) {
        // Convert DTO sang Entity
        Product product = productMapper.toEntity(dto);
        product.setCreatedOn(new java.util.Date());

        if (dto.getImages() != null && !dto.getImages().isEmpty()) {
            product.setImages(new ArrayList<>());
            dto.getImages().forEach(imgDto -> {
                Image img = new Image();
                img.setAlt(imgDto.getAlt());
                img.setFilename(imgDto.getFilename());
                img.setSrc(imgDto.getSrc());
                img.setSize(imgDto.getSize());
                img.setWidth(imgDto.getWidth());
                img.setHeight(imgDto.getHeight());
                img.setPosition(imgDto.getPosition());
                img.setCreatedOn(imgDto.getCreatedOn());
                img.setModifiedOn(imgDto.getModifiedOn());
                img.setProduct(product);
                product.getImages().add(img);
            });
        }

        if (dto.getVariants() != null && !dto.getVariants().isEmpty()) {
            product.setVariants(new ArrayList<>());
            dto.getVariants().forEach(varDto -> {
                Variant variant = new Variant();
                variant.setInventoryItemId(varDto.getInventoryItemId());
                variant.setBarcode(varDto.getBarcode());
                variant.setSku(varDto.getSku());
                variant.setPrice(varDto.getPrice());
                variant.setCompareAtPrice(varDto.getCompareAtPrice());
                variant.setOption1(varDto.getOption1());
                variant.setOption2(varDto.getOption2());
                variant.setOption3(varDto.getOption3());
                variant.setTaxable(varDto.getTaxable());
                variant.setInventoryManagement(varDto.getInventoryManagement());
                variant.setInventoryPolicy(varDto.getInventoryPolicy());
                variant.setInventoryQuantity(varDto.getInventoryQuantity());
                variant.setWeight(varDto.getWeight());
                variant.setWeightUnit(varDto.getWeightUnit());
                variant.setUnit(varDto.getUnit());
                variant.setPosition(varDto.getPosition());
                variant.setCreatedOn(varDto.getCreatedOn());
                variant.setModifiedOn(varDto.getModifiedOn());
                variant.setTitle(varDto.getTitle());
                variant.setGrams(varDto.getGrams());
                variant.setType(varDto.getType());
                variant.setRequiresComponents(varDto.getRequiresComponents());
                variant.setProduct(product);
                product.getVariants().add(variant);
            });
        }

        if (dto.getOptions() != null && !dto.getOptions().isEmpty()) {
            product.setOptions(new ArrayList<>());
            dto.getOptions().forEach(optDto -> {
                Option option = new Option();
                option.setName(optDto.getName());
                option.setPosition(optDto.getPosition());
                option.setProduct(product);
                product.getOptions().add(option);
            });
        }

        Product savedProduct = productRepository.save(product);

        return productMapper.toResponseDTO(savedProduct);
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
    @Transactional
    public Optional<ResponseProductDTO> updateProduct(int id, RequestProductDTO dto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        // Cập nhật các field cơ bản
        existingProduct.setProductName(dto.getProductName());
        existingProduct.setAlias(dto.getAlias());
        existingProduct.setVendor(dto.getVendor());
        existingProduct.setProductType(dto.getProductType());
        existingProduct.setMetaTitle(dto.getMetaTitle());
        existingProduct.setMetaDescription(dto.getMetaDescription());
        existingProduct.setSummary(dto.getSummary());
        existingProduct.setTemplateLayout(dto.getTemplateLayout());
        existingProduct.setPublishedOn(dto.getPublishedOn());
        existingProduct.setModifiedOn(new java.util.Date());
        existingProduct.setContent(dto.getContent());
        existingProduct.setTags(dto.getTags());
        existingProduct.setStatus(dto.getStatus());
        existingProduct.setType(dto.getType());

        // Clear danh sách cũ (cascade = ALL sẽ tự xóa trong DB)
        if (existingProduct.getImages() != null) {
            existingProduct.getImages().clear();
        }
        if (existingProduct.getVariants() != null) {
            existingProduct.getVariants().clear();
        }
        if (existingProduct.getOptions() != null) {
            existingProduct.getOptions().clear();
        }

        // Thêm lại images
        if (dto.getImages() != null && !dto.getImages().isEmpty()) {
            dto.getImages().forEach(imgDto -> {
                Image img = new Image();
                img.setAlt(imgDto.getAlt());
                img.setFilename(imgDto.getFilename());
                img.setSrc(imgDto.getSrc());
                img.setSize(imgDto.getSize());
                img.setWidth(imgDto.getWidth());
                img.setHeight(imgDto.getHeight());
                img.setPosition(imgDto.getPosition());
                img.setCreatedOn(imgDto.getCreatedOn());
                img.setModifiedOn(imgDto.getModifiedOn());
                img.setProduct(existingProduct);
                existingProduct.getImages().add(img);
            });
        }

        // Thêm lại variants
        if (dto.getVariants() != null && !dto.getVariants().isEmpty()) {
            dto.getVariants().forEach(varDto -> {
                Variant variant = new Variant();
                variant.setInventoryItemId(varDto.getInventoryItemId());
                variant.setBarcode(varDto.getBarcode());
                variant.setSku(varDto.getSku());
                variant.setPrice(varDto.getPrice());
                variant.setCompareAtPrice(varDto.getCompareAtPrice());
                variant.setOption1(varDto.getOption1());
                variant.setOption2(varDto.getOption2());
                variant.setOption3(varDto.getOption3());
                variant.setTaxable(varDto.getTaxable());
                variant.setInventoryManagement(varDto.getInventoryManagement());
                variant.setInventoryPolicy(varDto.getInventoryPolicy());
                variant.setInventoryQuantity(varDto.getInventoryQuantity());
                variant.setWeight(varDto.getWeight());
                variant.setWeightUnit(varDto.getWeightUnit());
                variant.setUnit(varDto.getUnit());
                variant.setPosition(varDto.getPosition());
                variant.setCreatedOn(varDto.getCreatedOn());
                variant.setModifiedOn(varDto.getModifiedOn());
                variant.setTitle(varDto.getTitle());
                variant.setGrams(varDto.getGrams());
                variant.setType(varDto.getType());
                variant.setRequiresComponents(varDto.getRequiresComponents());
                variant.setProduct(existingProduct);
                existingProduct.getVariants().add(variant);
            });
        }

        // Thêm lại options
        if (dto.getOptions() != null && !dto.getOptions().isEmpty()) {
            dto.getOptions().forEach(optDto -> {
                Option option = new Option();
                option.setName(optDto.getName());
                option.setPosition(optDto.getPosition());
                option.setProduct(existingProduct);
                existingProduct.getOptions().add(option);
            });
        }

        Product updatedProduct = productRepository.save(existingProduct);

        return Optional.ofNullable(productMapper.toResponseDTO(updatedProduct));
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
