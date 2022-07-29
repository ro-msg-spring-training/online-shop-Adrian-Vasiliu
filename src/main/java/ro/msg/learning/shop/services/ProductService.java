package ro.msg.learning.shop.services;

import ro.msg.learning.shop.domain.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    List<Product> getProducts();
    Product getProduct(Long id);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
