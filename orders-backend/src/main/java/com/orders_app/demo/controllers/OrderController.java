package com.orders_app.demo.controllers;


import com.orders_app.demo.models.OrderModel;
import com.orders_app.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<List<OrderModel>> getOrders(){
        List<OrderModel> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }
    @PostMapping
    public ResponseEntity<OrderModel> createOrder(@RequestBody OrderModel order){
        OrderModel createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
}
