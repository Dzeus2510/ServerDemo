package com.example.ProjectDemo.Services;

import com.example.ProjectDemo.Models.Product;
import com.example.ProjectDemo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findProductById(id);
    }

    public List<String> getProductByBillId(int id){
        return productRepository.findProductByBill(id);
    }

}
