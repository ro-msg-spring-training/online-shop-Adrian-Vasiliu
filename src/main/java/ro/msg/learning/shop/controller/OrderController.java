package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.domain.DTO.CreateOrderDTO;
import ro.msg.learning.shop.domain.DTO.OrderResponseDTO;
import ro.msg.learning.shop.domain.DTO.mapper.OrderMapper;
import ro.msg.learning.shop.domain.OrderProduct;
import ro.msg.learning.shop.service.OrderService;

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
    public OrderResponseDTO create(@RequestBody CreateOrderDTO createOrderDTO) {
        OrderProduct orderProduct = orderService.create(orderMapper.toOrder(createOrderDTO), createOrderDTO.getOrderedProducts());
        return orderMapper.toDTO(orderProduct);
    }

}
