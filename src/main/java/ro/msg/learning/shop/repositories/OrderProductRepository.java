package ro.msg.learning.shop.repositories;

import ro.msg.learning.shop.domain.OrderProduct;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends PagingAndSortingRepository<OrderProduct, Long> {
}
