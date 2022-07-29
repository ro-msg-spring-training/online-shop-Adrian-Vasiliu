package repositories;

import domain.OrderProduct;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends PagingAndSortingRepository<OrderProduct, Long> {
}
