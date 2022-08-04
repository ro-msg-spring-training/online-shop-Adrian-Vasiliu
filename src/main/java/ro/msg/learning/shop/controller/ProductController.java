package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.domain.DTO.ProductDTO;
import ro.msg.learning.shop.domain.DTO.mapper.ProductMapper;
import ro.msg.learning.shop.domain.Product;
import ro.msg.learning.shop.service.ProductService;

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
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        Product product = productService.create(productMapper.toProduct(productDTO));
        return productMapper.toDto(product);
    }

    @GetMapping(value = "")
    public List<ProductDTO> getProducts() {
        return productMapper.toDTOs(productService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long productId) {
        return productMapper.toDto(productService.getById(productId));
    }

    @PutMapping(value = "")
    public ProductDTO update(@RequestBody ProductDTO productDTO) {
        Product product = productService.update(productDTO.getId(), productMapper.toProduct(productDTO));
        return productMapper.toDto(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long productId) {
        productService.delete(productId);
    }

}
