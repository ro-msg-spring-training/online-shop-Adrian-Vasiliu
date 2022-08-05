package ro.msg.learning.shop.service.findingLocatonsStrategy;

import lombok.AllArgsConstructor;
import ro.msg.learning.shop.domain.Location;
import ro.msg.learning.shop.domain.Product;
import ro.msg.learning.shop.domain.Stock;
import ro.msg.learning.shop.exception.OutOfStockException;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.service.StockService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class MostAbundantStrategy implements FindingLocationsStrategy {
    private final StockService stockService;
    private final ProductService productService;

    @Override
    public List<ProductLocation> getProductLocations(Map<Long, Integer> orderedProducts) {
        List<ProductLocation> productLocationList = new ArrayList<>();
        for (Long key : orderedProducts.keySet()) {
            Integer biggestStock = 0;
            Location location = null;
            Product product = productService.getById(key);
            for (Stock stock : stockService.getAll()) {
                if (stock.getProduct().equals(product) && stock.getQuantity() >= orderedProducts.get(key) &&
                        stock.getQuantity() > biggestStock) {
                    biggestStock = stock.getQuantity();
                    location = stock.getLocation();
                }
            }
            if (biggestStock >= orderedProducts.get(key)) {
                productLocationList.add(new ProductLocation(location, product, orderedProducts.get(key)));
            } else throw new OutOfStockException("Out of stock!");
        }
        return productLocationList;
    }

}
