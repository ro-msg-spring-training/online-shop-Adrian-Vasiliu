package ro.msg.learning.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.domain.DTOs.ProductDTO;
import ro.msg.learning.shop.mappers.ProductMapper;
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
        productService.create(productMapper.toProduct(productDTO));
    }

    @GetMapping(value = "")
    public List<ProductDTO> getProducts() {
        return productMapper.toDTOs(productService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long productId) {
        return productMapper.toDto(productService.getById(productId));
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") Long productId, @RequestBody ProductDTO productDTO) {
        productService.update(productId, productMapper.toProduct(productDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long productId) {
        productService.delete(productId);
    }

}
