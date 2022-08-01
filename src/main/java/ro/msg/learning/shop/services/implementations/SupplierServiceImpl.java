package ro.msg.learning.shop.services.implementations;

import ro.msg.learning.shop.domain.Supplier;
import ro.msg.learning.shop.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repositories.SupplierRepository;
import ro.msg.learning.shop.services.SupplierService;

import java.util.Optional;

@Service
public class SupplierServiceImpl extends GenericServiceImpl<Supplier, SupplierRepository> implements SupplierService {

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        super(supplierRepository);
    }

//    @Override
//    public Supplier getByName(String name) {
//        Optional<Supplier> supplierOptional = repository.findByName(name);
//        if (supplierOptional.isPresent()) {
//            return supplierOptional.get();
//        }
//        throw new NotFoundException("Supplier not found!");
//    }

}
