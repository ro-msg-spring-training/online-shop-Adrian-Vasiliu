package ro.msg.learning.shop.service;

import ro.msg.learning.shop.domain.OrderProduct;

import java.util.Map;

public interface OrderService {
    OrderProduct create(OrderProduct order, Map<Long, Integer> orderedProducts);
}
