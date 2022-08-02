package ro.msg.learning.shop.services;

import ro.msg.learning.shop.domain.DTOs.OrderDTO;
import ro.msg.learning.shop.domain.OrderProduct;

public interface OrderService {
    OrderProduct create(OrderDTO orderDTO);
}
