package ro.msg.learning.shop.domain.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CreateProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private Long productCategoryId;
    private Long supplierId;
    private String imageUrl;
}
