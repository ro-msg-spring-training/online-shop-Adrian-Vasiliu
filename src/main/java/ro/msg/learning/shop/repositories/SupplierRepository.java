package ro.msg.learning.shop.repositories;

import ro.msg.learning.shop.domain.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Long> {
    Optional<Supplier> findByName(String name);
}
