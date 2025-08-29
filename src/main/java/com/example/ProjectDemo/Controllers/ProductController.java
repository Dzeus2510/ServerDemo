package com.example.ProjectDemo.Controllers;

import com.example.ProjectDemo.Models.Product;
import com.example.ProjectDemo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("/productbill/{id}")
    public List<String> getProductByBillId(@PathVariable int id){
        return productService.getProductByBillId(id);
    }
}
