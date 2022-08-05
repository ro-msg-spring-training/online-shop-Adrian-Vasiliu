package ro.msg.learning.shop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ro.msg.learning.shop.domain.Location;

public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {
}
