package ro.msg.learning.shop.repositories;

import ro.msg.learning.shop.domain.ProductCategory;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Long> {
    Optional<ProductCategory> findByName(String name);
}
