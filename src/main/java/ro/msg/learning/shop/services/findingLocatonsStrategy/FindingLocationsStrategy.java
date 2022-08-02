package ro.msg.learning.shop.services.findingLocatonsStrategy;

import ro.msg.learning.shop.domain.DTOs.OrderDTO;
import ro.msg.learning.shop.domain.OrderDetail;

import java.util.List;

public interface FindingLocationsStrategy {
    List<OrderDetail> getOrderDetails(OrderDTO orderDTO);
}
