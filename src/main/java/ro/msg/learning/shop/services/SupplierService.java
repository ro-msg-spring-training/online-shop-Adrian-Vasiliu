package ro.msg.learning.shop.services;

import ro.msg.learning.shop.domain.Supplier;

public interface SupplierService {
    Supplier getByName(String name);
}
