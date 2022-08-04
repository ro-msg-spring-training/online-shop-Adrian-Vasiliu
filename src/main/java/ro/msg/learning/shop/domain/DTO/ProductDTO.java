package ro.msg.learning.shop.domain.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
    private Long supplierId;
    private String supplierName;
    private String imageUrl;
}
