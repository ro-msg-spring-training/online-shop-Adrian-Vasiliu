package ro.msg.learning.shop.domain.DTO.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.domain.Customer;
import ro.msg.learning.shop.domain.DTO.CustomerDTO;
import ro.msg.learning.shop.domain.DTO.LocationDTO;
import ro.msg.learning.shop.domain.DTO.CreateOrderDTO;
import ro.msg.learning.shop.domain.DTO.OrderResponseDTO;
import ro.msg.learning.shop.domain.OrderProduct;
import ro.msg.learning.shop.service.CustomerService;

@Component
public class OrderMapper {
    private final CustomerService customerService;
    private final LocationMapper locationMapper;
    private final CustomerMapper customerMapper;

    @Autowired
    public OrderMapper(CustomerService customerService, LocationMapper locationMapper, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.locationMapper = locationMapper;
        this.customerMapper = customerMapper;
    }

    public OrderProduct toOrder(CreateOrderDTO createOrderDTO) {
        Customer customer = customerService.getById(createOrderDTO.getCustomerId());
        return new OrderProduct(null, customer, createOrderDTO.getCreatedAt(), createOrderDTO.getAddressCountry(),
                createOrderDTO.getAddressCity(), createOrderDTO.getAddressCounty(), createOrderDTO.getAddressStreet());
    }

    public OrderResponseDTO toDTO(OrderProduct orderProduct) {
        LocationDTO locationDTO = locationMapper.toDTO(orderProduct.getShippedFrom());
        CustomerDTO customerDTO = customerMapper.toDTO(orderProduct.getCustomer());
        return new OrderResponseDTO(orderProduct.getId(), locationDTO, customerDTO, orderProduct.getCreatedAt(),
                orderProduct.getAddressCountry(), orderProduct.getAddressCity(), orderProduct.getAddressCounty(),
                orderProduct.getAddressStreet());
    }

}
