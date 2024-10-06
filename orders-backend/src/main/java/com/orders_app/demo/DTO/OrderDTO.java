package com.orders_app.demo.DTO;

import java.time.LocalDateTime;

public class OrderDTO {
    private Long id;
    private Long clienteId;  // ID del cliente
    private Long idTipoOrden;  // ID del cliente
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaToma;  // Puede ser nulo
    private LocalDateTime fechaFinalizacion;  // Puede ser nulo
    private Long idUsuarioCreador;  // Puede ser nulo

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

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaToma(LocalDateTime fechaToma) {
        this.fechaToma = fechaToma;
    }

    public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaToma() {
        return fechaToma;
    }

    public LocalDateTime getFechaFinalizacion() {
        return fechaFinalizacion;
    }


    // Getters y setters
}