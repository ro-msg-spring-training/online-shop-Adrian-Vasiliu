package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.Customer;
import ro.msg.learning.shop.repository.CustomerRepository;
import ro.msg.learning.shop.service.CustomerService;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, CustomerRepository> implements CustomerService {

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
