package ro.msg.learning.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.domain.DTOs.OrderDTO;
import ro.msg.learning.shop.domain.DTOs.mappers.OrderMapper;
import ro.msg.learning.shop.domain.OrderProduct;
import ro.msg.learning.shop.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping(value = "")
    public OrderProduct create(@RequestBody OrderDTO orderDTO) {
        return orderService.create(orderMapper.toOrder(orderDTO), orderDTO.getOrderedProducts());
    }

}
