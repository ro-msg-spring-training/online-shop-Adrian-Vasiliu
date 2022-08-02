package ro.msg.learning.shop.services.findingLocatonsStrategy;

import ro.msg.learning.shop.domain.DTOs.OrderDTO;

import java.util.List;

public interface FindingLocationsStrategy {
    List<ProductLocation> getProductLocations(OrderDTO orderDTO);
}
