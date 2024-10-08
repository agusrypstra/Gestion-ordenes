package com.orders_app.demo.DTO.client;

import com.orders_app.demo.models.TipoClienteModel;
import org.springframework.stereotype.Component;

@Component
public class ResponseClientDTO {
    public ResponseClientDTO() {
    }

    private Long id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String direccionIp;
    private TipoClienteModel tipoClienteModel;
    private String telefonoContacto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public TipoClienteModel getTipoClienteModel() {
        return tipoClienteModel;
    }

    public void setTipoClienteModel(TipoClienteModel tipoClienteModel) {
        this.tipoClienteModel = tipoClienteModel;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
}
