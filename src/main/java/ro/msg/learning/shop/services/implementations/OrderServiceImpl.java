package ro.msg.learning.shop.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.DTOs.OrderDTO;
import ro.msg.learning.shop.domain.OrderDetail;
import ro.msg.learning.shop.services.OrderService;
import ro.msg.learning.shop.services.findingLocatonsStrategy.FindingLocationsConfig;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final FindingLocationsConfig findingLocationsConfig;

//    @Autowired
//    public OrderServiceImpl(FindingLocationsStrategy findingLocationsStrategy) {
//        this.findingLocationsStrategy = findingLocationsStrategy;
//    }

    public List<OrderDetail> createOrder(OrderDTO orderDTO) {
        return findingLocationsConfig.chooseStrategy().getOrderDetails(orderDTO);
    }

}
