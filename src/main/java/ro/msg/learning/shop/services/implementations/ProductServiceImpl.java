package ro.msg.learning.shop.services.implementations;

import ro.msg.learning.shop.domain.Product;
import ro.msg.learning.shop.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.services.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return (List<Product>) this.productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new NotFoundException("Product not found");
        }
        return productOptional.get();
    }

    @Override
    public void updateProduct(Long id, Product newProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new NotFoundException("Product not found");
        }
        createProduct(newProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new NotFoundException("Product not found");
        }
        productRepository.deleteById(id);
    }

}
