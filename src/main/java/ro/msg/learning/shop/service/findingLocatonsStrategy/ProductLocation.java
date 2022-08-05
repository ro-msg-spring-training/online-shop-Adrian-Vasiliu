package ro.msg.learning.shop.service.findingLocatonsStrategy;

import lombok.*;
import ro.msg.learning.shop.domain.Location;
import ro.msg.learning.shop.domain.Product;

@Data
@AllArgsConstructor
public class ProductLocation {
    private Location location;
    private Product product;
    private Integer quantity;
}
