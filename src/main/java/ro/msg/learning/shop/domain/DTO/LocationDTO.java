package ro.msg.learning.shop.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationDTO {
    private Long id;
    private String name;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreet;
}
