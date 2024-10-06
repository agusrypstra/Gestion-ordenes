package com.orders_app.demo.services;

import com.orders_app.demo.DTO.OrderDTO;
import com.orders_app.demo.mappers.OrderMapper;
import com.orders_app.demo.models.OrderModel;
import com.orders_app.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::toDTO)  // Usa el mapper
                .collect(Collectors.toList());
    }
    public OrderModel saveOrder(OrderModel order) {
        return orderRepository.save(order);
    }
    public boolean deleteOrder(Long id) {
        Optional<OrderModel> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
