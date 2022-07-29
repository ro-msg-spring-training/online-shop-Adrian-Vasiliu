package ro.msg.learning.shop.domain.DTOs;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private String categoryName;
    private String categoryDescription;
    private String supplierName;
    private String imageUrl;
}
