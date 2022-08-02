package ro.msg.learning.shop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.Customer;
import ro.msg.learning.shop.repositories.CustomerRepository;
import ro.msg.learning.shop.services.CustomerService;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, CustomerRepository> implements CustomerService {

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
