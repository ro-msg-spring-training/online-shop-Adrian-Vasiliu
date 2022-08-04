package ro.msg.learning.shop.service.findingLocatonsStrategy;

import lombok.AllArgsConstructor;
import ro.msg.learning.shop.domain.Location;
import ro.msg.learning.shop.domain.Stock;
import ro.msg.learning.shop.exception.OutOfStockException;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.service.StockService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class SingleLocationStrategy implements FindingLocationsStrategy {
    private final StockService stockService;
    private final ProductService productService;

    @Override
    public List<ProductLocation> getProductLocations(Map<Long, Integer> orderedProducts) {
        Location location = null;
        for (Long key : orderedProducts.keySet()) {
            boolean stockOk = false;
            for (Stock stock : stockService.getAll()) {
                if (stock.getProduct().equals(productService.getById(key)) &&
                        stock.getQuantity() >= orderedProducts.get(key)) {
                    if (location == null) {
                        location = stock.getLocation();
                        stockOk = true;
                        break;
                    } else {
                        if (stock.getLocation().equals(location)) {
                            location = stock.getLocation();
                            stockOk = true;
                            break;
                        }
                    }
                }
            }
            if (!stockOk) {
                throw new OutOfStockException("Out of stock!");
            }
        }
        List<ProductLocation> productLocationList = new ArrayList<>();
        for (Long key : orderedProducts.keySet()) {
            productLocationList.add(new ProductLocation(location, productService.getById(key), orderedProducts.get(key)));
        }
        return productLocationList;
    }

}
