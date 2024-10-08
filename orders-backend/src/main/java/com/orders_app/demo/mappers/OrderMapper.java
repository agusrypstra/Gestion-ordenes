package com.orders_app.demo.mappers;

import com.orders_app.demo.DTO.order.OrderDTO;
import com.orders_app.demo.models.ClientModel;
import com.orders_app.demo.models.OrderModel;
import com.orders_app.demo.models.OrderTypeModel;
import com.orders_app.demo.models.UsuarioModel;

public class OrderMapper {

    public static OrderDTO toDTO(OrderModel order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setClienteId(order.getId());
        dto.setDescripcion(order.getDescripcion());
        dto.setIdTipoOrden(order.getTipoOrden().getId());
        dto.setFechaCreacion(order.getFechaCreacion());
        dto.setIdUsuarioCreador(order.getUsuarioCreador().getId());
        return dto;
    }

    public static OrderModel toEntity(OrderDTO dto) {
        OrderModel order = new OrderModel();
        order.setId(dto.getId());
        order.setCliente(new ClientModel(dto.getClienteId()));  // Supongamos que tienes un constructor adecuado
        order.setDescripcion(dto.getDescripcion());
        order.setFechaCreacion(dto.getFechaCreacion());
        order.setTipoOrden(new OrderTypeModel(dto.getIdTipoOrden()));
        order.setUsuarioCreador(new UsuarioModel(dto.getIdUsuarioCreador()));
        return order;
    }
}