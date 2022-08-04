package ro.msg.learning.shop.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
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
