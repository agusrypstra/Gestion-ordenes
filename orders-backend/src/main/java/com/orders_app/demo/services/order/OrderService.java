package com.orders_app.demo.services.order;

import com.orders_app.demo.DTO.order.OrderDTO;
import com.orders_app.demo.mappers.OrderMapper;
import com.orders_app.demo.models.ClientModel;
import com.orders_app.demo.models.OrderModel;
import com.orders_app.demo.models.OrderTypeModel;
import com.orders_app.demo.repositories.OrderRepository;
import com.orders_app.demo.rest.OrderREST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public OrderModel saveOrder(OrderREST orderREST) {
        OrderModel order = OrderMapper.toEntity(orderREST);
        order.setFechaCreacion(LocalDateTime.now());
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
    public OrderModel updateOrder(Long id, OrderREST orderREST) {
        // Buscar la orden por ID
        OrderModel existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        // Actualizar los atributos de la orden existente
        existingOrder.setDescripcion(orderREST.getDescripcion());
        existingOrder.setCliente(new ClientModel(orderREST.getClienteId()));
        existingOrder.setTipoOrden(new OrderTypeModel(orderREST.getIdTipoOrden()));
        existingOrder.setFechaToma(orderREST.getFechaToma());
        existingOrder.setFechaFinalizacion(orderREST.getFechaFinalizacion());
        // Aquí puedes actualizar otros atributos según lo que haya en el DTO

        // Guardar la orden actualizada
        return orderRepository.save(existingOrder);
    }
}
