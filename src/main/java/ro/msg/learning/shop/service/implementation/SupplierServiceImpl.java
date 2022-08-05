package ro.msg.learning.shop.service.implementation;

import ro.msg.learning.shop.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repository.SupplierRepository;
import ro.msg.learning.shop.service.SupplierService;

@Service
public class SupplierServiceImpl extends GenericServiceImpl<Supplier, SupplierRepository> implements SupplierService {

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        super(supplierRepository);
    }

}
