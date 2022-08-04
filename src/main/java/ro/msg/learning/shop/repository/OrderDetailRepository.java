package ro.msg.learning.shop.repository;

import ro.msg.learning.shop.domain.OrderDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends PagingAndSortingRepository<OrderDetail, Long> {
}
