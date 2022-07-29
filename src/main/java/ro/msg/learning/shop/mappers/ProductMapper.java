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
        return new ProductDTO(product.getName(),product.getDescription(), product.getPrice(), product.getWeight(),
                productCategory.getName(),productCategory.getDescription(), supplier.getName(), product.getImageUrl());
    }

    public List<ProductDTO> toDTOs (List<Product> products) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        for(Product product: products) {
            productsDTO.add(toDto(product));
        }
        return productsDTO;
    }

    public Product toProduct(ProductDTO createProductDTO) {
        ProductCategory productCategory = productCategoryService.getByName(createProductDTO.getCategoryName());
        Supplier supplier = supplierService.getByName(createProductDTO.getSupplierName());
        return new Product(createProductDTO.getName(), createProductDTO.getDescription(), createProductDTO.getPrice(),
                createProductDTO.getWeight(), productCategory, supplier, createProductDTO.getImageUrl());
    }

//    public Product toProduct(ProductDTO productDTO) {
//
//        return new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(),
//                productDTO.getWeight(),productDTO.);
//    }
}
