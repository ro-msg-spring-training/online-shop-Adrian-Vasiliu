package ro.msg.learning.shop.repository;

import ro.msg.learning.shop.domain.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Long> {
    // Optional<Supplier> findByName(String name);
}
