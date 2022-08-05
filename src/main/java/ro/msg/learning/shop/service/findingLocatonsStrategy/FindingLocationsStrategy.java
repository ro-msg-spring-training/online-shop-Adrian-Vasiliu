package ro.msg.learning.shop.service.findingLocatonsStrategy;

import java.util.List;
import java.util.Map;

public interface FindingLocationsStrategy {
    List<ProductLocation> getProductLocations(Map<Long, Integer> orderedProducts);
}
