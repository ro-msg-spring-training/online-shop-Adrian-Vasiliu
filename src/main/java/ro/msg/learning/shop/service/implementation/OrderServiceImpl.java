package ro.msg.learning.shop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.OrderDetail;
import ro.msg.learning.shop.domain.OrderProduct;
import ro.msg.learning.shop.repository.OrderDetailRepository;
import ro.msg.learning.shop.repository.OrderProductRepository;
import ro.msg.learning.shop.service.OrderService;
import ro.msg.learning.shop.service.StockService;
import ro.msg.learning.shop.service.findingLocatonsStrategy.FindingLocationsStrategy;
import ro.msg.learning.shop.service.findingLocatonsStrategy.ProductLocation;

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
