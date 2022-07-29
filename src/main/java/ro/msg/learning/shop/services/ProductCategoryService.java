package ro.msg.learning.shop.services;

import ro.msg.learning.shop.domain.ProductCategory;

public interface ProductCategoryService {
    ProductCategory getByName(String name);
}
