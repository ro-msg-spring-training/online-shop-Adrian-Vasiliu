package ro.msg.learning.shop.controllers;

import ro.msg.learning.shop.domain.DTOs.ProductDTO;
import ro.msg.learning.shop.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping(value = "")
    public void create(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productMapper.toProduct(productDTO));
    }

    @GetMapping(value = "/all-products")
    public List<ProductDTO> getProducts() {
        return productMapper.toDTOs(productService.getProducts());
    }

}