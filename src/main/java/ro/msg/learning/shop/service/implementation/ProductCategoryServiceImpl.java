package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.ProductCategory;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl extends GenericServiceImpl<ProductCategory, ProductCategoryRepository>
        implements ProductCategoryService {

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        super(productCategoryRepository);
    }

}
