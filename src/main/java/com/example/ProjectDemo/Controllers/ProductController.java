package com.example.ProjectDemo.Controllers;

import com.example.ProjectDemo.DTO.RequestProductDTO;
import com.example.ProjectDemo.DTO.ResponseProductDTO;
import com.example.ProjectDemo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping()
    public ResponseEntity<ResponseProductDTO> create(@RequestBody RequestProductDTO dto) {
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    // Get all
    @GetMapping()
    public ResponseEntity<List<ResponseProductDTO>> getAll() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> getById(@PathVariable int id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> update(@PathVariable int id, @RequestBody RequestProductDTO dto) {
        return productService.updateProduct(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = productService.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
