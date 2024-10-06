package com.orders_app.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_cliente")
public class TipoClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public TipoClienteModel() {
    }
    @Column(name="nombre_tipo",nullable = false)
    private String nombre_tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }
}
