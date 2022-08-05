package ro.msg.learning.shop.repository;

import ro.msg.learning.shop.domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
