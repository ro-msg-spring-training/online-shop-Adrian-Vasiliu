package ro.msg.learning.shop.mappers;

import ro.msg.learning.shop.domain.DTOs.ProductDTO;
import ro.msg.learning.shop.domain.Product;
import ro.msg.learning.shop.domain.ProductCategory;
import ro.msg.learning.shop.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.services.ProductCategoryService;
import ro.msg.learning.shop.services.SupplierService;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    private final ProductCategoryService productCategoryService;
    private final SupplierService supplierService;

    @Autowired
    public ProductMapper(ProductCategoryService productCategoryService, SupplierService supplierService) {
        this.productCategoryService = productCategoryService;
        this.supplierService = supplierService;
    }

    public ProductDTO toDto(Product product) {
        ProductCategory productCategory = product.getProductCategory();
        Supplier supplier = product.getSupplier();
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                product.getWeight(), productCategory.getId(), productCategory.getName(),
                productCategory.getDescription(), supplier.getId(), supplier.getName(), product.getImageUrl());
    }

    public List<ProductDTO> toDTOs(List<Product> products) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (Product product : products) {
            productsDTO.add(toDto(product));
        }
        return productsDTO;
    }

    public Product toProduct(ProductDTO productDTO) {
        ProductCategory productCategory = productCategoryService.getById(productDTO.getCategoryId());
        Supplier supplier = supplierService.getById(productDTO.getSupplierId());
        return new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(),
                productDTO.getWeight(), productCategory, supplier, productDTO.getImageUrl());
    }

}
