package ro.msg.learning.shop.services.findingLocatonsStrategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.domain.DTOs.OrderDTO;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SingleLocationStrategy implements FindingLocationsStrategy {

//    @Autowired
//    public SingleLocationStrategy(StockService stockService) {
//        this.stockService = stockService;
//    }

    @Override
    public List<ProductLocation> getProductLocations(OrderDTO orderDTO) {
        return null;
    }

}
