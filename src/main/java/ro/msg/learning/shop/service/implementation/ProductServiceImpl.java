package ro.msg.learning.shop.service.implementation;

import ro.msg.learning.shop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.service.ProductService;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, ProductRepository> implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
    }

}
