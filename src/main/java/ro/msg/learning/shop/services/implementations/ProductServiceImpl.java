package ro.msg.learning.shop.services.implementations;

import ro.msg.learning.shop.domain.Product;
import ro.msg.learning.shop.domain.Supplier;
import ro.msg.learning.shop.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.SupplierRepository;
import ro.msg.learning.shop.services.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, ProductRepository> implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
    }

}
