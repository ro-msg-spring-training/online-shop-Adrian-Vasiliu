package ro.msg.learning.shop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.ProductCategory;
import ro.msg.learning.shop.repositories.ProductCategoryRepository;
import ro.msg.learning.shop.services.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl extends GenericServiceImpl<ProductCategory, ProductCategoryRepository>
        implements ProductCategoryService {

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        super(productCategoryRepository);
    }

}
