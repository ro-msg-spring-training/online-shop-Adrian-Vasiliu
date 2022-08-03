package ro.msg.learning.shop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.OrderDetail;
import ro.msg.learning.shop.domain.OrderProduct;
import ro.msg.learning.shop.repositories.OrderDetailRepository;
import ro.msg.learning.shop.repositories.OrderProductRepository;
import ro.msg.learning.shop.services.OrderService;
import ro.msg.learning.shop.services.StockService;
import ro.msg.learning.shop.services.findingLocatonsStrategy.FindingLocationsStrategy;
import ro.msg.learning.shop.services.findingLocatonsStrategy.ProductLocation;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    private final FindingLocationsStrategy findingLocationsStrategy;
    private final OrderProductRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final StockService stockService;

    @Autowired
    public OrderServiceImpl(FindingLocationsStrategy findingLocationsStrategy,
                            OrderProductRepository orderProductRepository, OrderDetailRepository orderDetailRepository,
                            StockService stockService) {
        this.findingLocationsStrategy = findingLocationsStrategy;
        this.orderRepository = orderProductRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.stockService = stockService;
    }

    public OrderProduct create(OrderProduct order, Map<Long, Integer> orderedProducts) {
        List<ProductLocation> productLocationList = findingLocationsStrategy.getProductLocations(orderedProducts);
        order.setShippedFrom(productLocationList.get(0).getLocation());
        orderRepository.save(order);
        for (ProductLocation productLocation : productLocationList) {
            OrderDetail orderDetail = new OrderDetail(order, productLocation.getProduct(),
                    productLocation.getQuantity());
            orderDetailRepository.save(orderDetail);
        }
        stockService.updateStocks(productLocationList);
        return order;
    }

}
