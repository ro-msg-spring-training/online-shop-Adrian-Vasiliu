package ro.msg.learning.shop.services.findingLocatonsStrategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.domain.DTOs.OrderDTO;
import ro.msg.learning.shop.domain.Location;
import ro.msg.learning.shop.domain.Product;
import ro.msg.learning.shop.domain.Stock;
import ro.msg.learning.shop.exceptions.OutOfStockException;
import ro.msg.learning.shop.services.ProductService;
import ro.msg.learning.shop.services.StockService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MostAbundantStrategy implements FindingLocationsStrategy {
    private final StockService stockService;
    private final ProductService productService;

//    @Autowired
//    public MostAbundantStrategy(StockService stockService) {
//        this.stockService = stockService;
//    }

    @Override
    public List<ProductLocation> getProductLocations(OrderDTO orderDTO) {
        List<ProductLocation> productLocationList = new ArrayList<>();
        Map<Long, Integer> orderedProducts = orderDTO.getOrderedProducts();
        for (Long key : orderedProducts.keySet()) {
            Integer biggestStock = 0;
            Location location = null;
            Product product = productService.getById(key);
            for (Stock stock : stockService.getAll()) {
                Integer quantity = stock.getQuantity();
                if (stock.getProduct().equals(product) && quantity >= orderedProducts.get(key) && quantity > biggestStock) {
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
