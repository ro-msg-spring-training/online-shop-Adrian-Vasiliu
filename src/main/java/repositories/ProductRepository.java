package repositories;

import domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
