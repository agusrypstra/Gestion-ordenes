package com.orders_app.demo.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "tipo_orden")
public class TipoOrdenModel {
    @Autowired
    public TipoOrdenModel(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_tipo;

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
