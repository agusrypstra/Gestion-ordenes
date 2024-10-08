package com.orders_app.demo.controllers.order;


import com.orders_app.demo.DTO.order.OrderDTO;
import com.orders_app.demo.mappers.OrderMapper;
import com.orders_app.demo.models.OrderModel;
import com.orders_app.demo.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders() {
        List<OrderDTO> orders = orderService.findAllOrders();
        return ResponseEntity.ok(orders);
    }
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderModel order = OrderMapper.toEntity(orderDTO);
        OrderModel savedOrder = orderService.saveOrder(order);
        OrderDTO savedOrderDTO = OrderMapper.toDTO(savedOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrderDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        boolean deleted = orderService.deleteOrder(id);
        if (deleted) {
            return ResponseEntity.ok("Order deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
    }
}
