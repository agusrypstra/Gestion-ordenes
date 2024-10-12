package com.orders_app.demo.rest;

import com.orders_app.demo.models.OrderStatus;

import java.time.LocalDateTime;

public class OrderREST {
    private Long id;
    private Long clienteId;  // ID del cliente
    private Long idTipoOrden;  // ID del cliente
    private String descripcion;
    private Long idUsuarioCreador;  // Puede ser nulo
    private OrderStatus status;
    private LocalDateTime fechaToma;
    private LocalDateTime fechaFinalizacion;

    public LocalDateTime getFechaToma() {
        return fechaToma;
    }

    public void setFechaToma(LocalDateTime fechaToma) {
        this.fechaToma = fechaToma;
    }

    public LocalDateTime getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getIdUsuarioCreador() {
        return idUsuarioCreador;
    }

    public Long getIdTipoOrden() {
        return idTipoOrden;
    }

    public void setIdTipoOrden(Long idTipoOrden) {
        this.idTipoOrden = idTipoOrden;
    }

    public void setIdUsuarioCreador(Long idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Long getId() {
        return id;
    }
    public Long getClienteId() {
        return clienteId;
    }

    public String getDescripcion() {
        return descripcion;
    }
}