package ro.msg.learning.shop.services.findingLocatonsStrategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.domain.*;
import ro.msg.learning.shop.domain.DTOs.OrderDTO;
import ro.msg.learning.shop.exceptions.OutOfStockException;
import ro.msg.learning.shop.services.CustomerService;
import ro.msg.learning.shop.services.ProductService;
import ro.msg.learning.shop.services.StockService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SingleLocationStrategy implements FindingLocationsStrategy {
    private final StockService stockService;
    private final ProductService productService;
    private final CustomerService customerService;
    //    @Autowired
//    public SingleLocationStrategy(StockService stockService) {
//        this.stockService = stockService;
//    }

    public List<OrderDetail> getOrderDetails(OrderDTO orderDTO) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        Map<Long, Integer> orderedProducts = orderDTO.getOrderedProducts();
        for (Long key : orderedProducts.keySet()) {
            boolean stockOk = false;
            for (Stock stock : stockService.getAll()) {
                Product product = productService.getById(key);
                if (stock.getProduct().getId().equals(product.getId()) &&
                        stock.getQuantity() >= orderedProducts.get(key)) {
                    Customer customer = customerService.getById(orderDTO.getCustomerId());
                    OrderProduct orderProduct = new OrderProduct(stock.getLocation(), customer, orderDTO.getCreatedAt(),
                            orderDTO.getAddressCountry(), orderDTO.getAddressCity(), orderDTO.getAddressCounty(),
                            orderDTO.getAddressStreet());
                    orderDetailList.add(new OrderDetail(orderProduct, product, orderedProducts.get(key)));
                    stockOk = true;
                }
            }
            if (!stockOk) {
                throw new OutOfStockException("Stock or location not found!");
            }
        }
        return orderDetailList;
    }

}
