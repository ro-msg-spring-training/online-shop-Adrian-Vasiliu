package ro.msg.learning.shop.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.DTOs.OrderDTO;
import ro.msg.learning.shop.domain.OrderProduct;
import ro.msg.learning.shop.services.OrderService;
import ro.msg.learning.shop.services.findingLocatonsStrategy.FindingLocationsConfig;
import ro.msg.learning.shop.services.findingLocatonsStrategy.ProductLocation;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final FindingLocationsConfig findingLocationsConfig;

//    @Autowired
//    public OrderServiceImpl(FindingLocationsStrategy findingLocationsStrategy) {
//        this.findingLocationsStrategy = findingLocationsStrategy;
//    }

    public OrderProduct create(OrderDTO orderDTO) {
        List<ProductLocation> productLocationList = findingLocationsConfig.chooseStrategy().getProductLocations(orderDTO);
        System.out.println(productLocationList);
        return null;
    }

}
