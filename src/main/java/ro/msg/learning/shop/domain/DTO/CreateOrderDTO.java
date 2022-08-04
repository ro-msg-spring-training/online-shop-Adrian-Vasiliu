package ro.msg.learning.shop.domain.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
public class CreateOrderDTO {
    private Long customerId;
    private LocalDateTime createdAt;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreet;
    private Map<Long, Integer> orderedProducts;
}
