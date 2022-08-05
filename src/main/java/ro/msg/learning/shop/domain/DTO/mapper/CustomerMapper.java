package ro.msg.learning.shop.domain.DTO.mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.domain.Customer;
import ro.msg.learning.shop.domain.DTO.CustomerDTO;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getUsername(), customer.getLastName(), customer.getUsername(),
                customer.getPassword(), customer.getEmailAddress());
    }

}
