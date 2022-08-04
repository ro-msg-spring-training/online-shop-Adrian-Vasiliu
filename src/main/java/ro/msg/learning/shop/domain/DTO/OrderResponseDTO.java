package ro.msg.learning.shop.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private LocationDTO shippedFrom;
    private CustomerDTO customer;
    private LocalDateTime createdAt;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreet;
}
