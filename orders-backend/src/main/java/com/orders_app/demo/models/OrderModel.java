package com.orders_app.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientModel cliente;

    @Column(length = 255)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "tipo_orden_id", nullable = false)
    private OrderTypeModel tipoOrden;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaToma;

    private LocalDateTime fechaFinalizacion;

    @ManyToOne
    @JoinColumn(name = "usuario_creador_id", nullable = false)
    private UsuarioModel usuarioCreador;

    @ManyToOne
    @JoinColumn(name = "usuario_tomo_id")
    private UsuarioModel usuarioTomo;

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ClientModel getCliente() {
        return cliente;
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

    public void setId(Long id) {
        this.id = id;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public OrderTypeModel getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(OrderTypeModel tipoOrden) {
        this.tipoOrden = tipoOrden;
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

    public UsuarioModel getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(UsuarioModel usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public UsuarioModel getUsuarioTomo() {
        return usuarioTomo;
    }

    public void setUsuarioTomo(UsuarioModel usuarioTomo) {
        this.usuarioTomo = usuarioTomo;
    }

    public void setCliente(ClientModel clientModel) {
        this.cliente = clientModel;
    }
}
