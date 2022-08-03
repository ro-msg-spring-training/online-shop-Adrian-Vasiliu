package ro.msg.learning.shop.domain.DTOs.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.domain.Customer;
import ro.msg.learning.shop.domain.DTOs.OrderDTO;
import ro.msg.learning.shop.domain.OrderProduct;
import ro.msg.learning.shop.services.CustomerService;

@Component
public class OrderMapper {
    private final CustomerService customerService;

    @Autowired
    public OrderMapper(CustomerService customerService) {
        this.customerService = customerService;
    }

    public OrderProduct toOrder(OrderDTO orderDTO) {
        Customer customer = customerService.getById(orderDTO.getCustomerId());
        return new OrderProduct(null, customer, orderDTO.getCreatedAt(), orderDTO.getAddressCountry(),
                orderDTO.getAddressCity(),orderDTO.getAddressCounty(), orderDTO.getAddressStreet());
    }

}
