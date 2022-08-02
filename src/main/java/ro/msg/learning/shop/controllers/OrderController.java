package ro.msg.learning.shop.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.domain.DTOs.OrderDTO;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping(value = "")
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {
        // orderService.create(productMapper.toProduct(orderDTO));
        return orderDTO;
    }

}
