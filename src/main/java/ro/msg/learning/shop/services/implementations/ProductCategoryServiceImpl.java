package ro.msg.learning.shop.services.implementations;

import ro.msg.learning.shop.domain.ProductCategory;
import ro.msg.learning.shop.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repositories.ProductCategoryRepository;
import ro.msg.learning.shop.services.ProductCategoryService;

import java.util.Optional;

@Service
public class ProductCategoryServiceImpl extends GenericServiceImpl<ProductCategory, ProductCategoryRepository>
        implements ProductCategoryService {

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        super(productCategoryRepository);
    }

//    @Override
//    public ProductCategory getByName(String name) {
//        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findByName(name);
//        if (!productCategoryOptional.isPresent()) {
//            throw new NotFoundException("Product category not found");
//        }
//        return productCategoryOptional.get();
//    }

}
