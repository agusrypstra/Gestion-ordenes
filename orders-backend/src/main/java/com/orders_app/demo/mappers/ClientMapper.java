package com.orders_app.demo.mappers;

import com.orders_app.demo.rest.ClientREST;
import com.orders_app.demo.DTO.client.ResponseClientDTO;
import com.orders_app.demo.models.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public static ResponseClientDTO toResponseDTO(ClientModel clientModel) {
        if (clientModel == null) {
            return null;
        }

        ResponseClientDTO responseClientDTO = new ResponseClientDTO();
        responseClientDTO.setId(clientModel.getId());
        responseClientDTO.setApellido(clientModel.getApellido());
        responseClientDTO.setNombre(clientModel.getNombre());
        responseClientDTO.setDomicilio(clientModel.getDomicilio());
        responseClientDTO.setDireccionIp(clientModel.getDireccionIp());
        responseClientDTO.setTipoClienteModel(clientModel.getTipoCliente());
        responseClientDTO.setTelefonoContacto(clientModel.getTelefonoContacto());

        return responseClientDTO;
    }

    // Método para convertir ClientModel a ClientDTO
    public static ClientREST toCreateDTO(ClientModel clientModel) {
        if (clientModel == null) {
            return null;
        }

        ClientREST clientREST = new ClientREST();
        clientREST.setId(clientModel.getId());
        clientREST.setApellido(clientModel.getApellido());
        clientREST.setNombre(clientModel.getNombre());
        clientREST.setDni(clientModel.getDni());
        clientREST.setDomicilio(clientModel.getDomicilio());
        clientREST.setDireccionIp(clientModel.getDireccionIp());
        clientREST.setTipoClienteModel(clientModel.getTipoCliente());
        clientREST.setTelefonoContacto(clientModel.getTelefonoContacto());

        return clientREST;
    }

    // Método para convertir ClientDTO a ClientModel
    public ClientModel toModel(ClientREST clientREST) {
        if (clientREST == null) {
            return null;
        }

        ClientModel clientModel = new ClientModel();
        clientModel.setId(clientREST.getId());
        clientModel.setApellido(clientREST.getApellido());
        clientModel.setNombre(clientREST.getNombre());
        clientModel.setDni(clientREST.getDni());
        clientModel.setDomicilio(clientREST.getDomicilio());
        clientModel.setDireccionIp(clientREST.getDireccionIp());
        clientModel.setTipoCliente(clientREST.getTipoClienteModel());
        clientModel.setTelefonoContacto(clientREST.getTelefonoContacto());

        return clientModel;
    }
}