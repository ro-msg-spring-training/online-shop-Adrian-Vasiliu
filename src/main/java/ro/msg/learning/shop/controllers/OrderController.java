package ro.msg.learning.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.domain.DTOs.OrderDTO;
import ro.msg.learning.shop.domain.OrderProduct;
import ro.msg.learning.shop.services.OrderService;
import ro.msg.learning.shop.services.StockService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService, StockService stockService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "")
    public OrderProduct create(@RequestBody OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }

}
