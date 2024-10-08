package com.orders_app.demo.mappers;

import com.orders_app.demo.DTO.client.CreateClientDTO;
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
    public static CreateClientDTO toCreateDTO(ClientModel clientModel) {
        if (clientModel == null) {
            return null;
        }

        CreateClientDTO createClientDTO = new CreateClientDTO();
        createClientDTO.setId(clientModel.getId());
        createClientDTO.setApellido(clientModel.getApellido());
        createClientDTO.setNombre(clientModel.getNombre());
        createClientDTO.setDni(clientModel.getDni());
        createClientDTO.setDomicilio(clientModel.getDomicilio());
        createClientDTO.setDireccionIp(clientModel.getDireccionIp());
        createClientDTO.setTipoClienteModel(clientModel.getTipoCliente());
        createClientDTO.setTelefonoContacto(clientModel.getTelefonoContacto());

        return createClientDTO;
    }

    // Método para convertir ClientDTO a ClientModel
    public ClientModel toModel(CreateClientDTO createClientDTO) {
        if (createClientDTO == null) {
            return null;
        }

        ClientModel clientModel = new ClientModel();
        clientModel.setId(createClientDTO.getId());
        clientModel.setApellido(createClientDTO.getApellido());
        clientModel.setNombre(createClientDTO.getNombre());
        clientModel.setDni(createClientDTO.getDni());
        clientModel.setDomicilio(createClientDTO.getDomicilio());
        clientModel.setDireccionIp(createClientDTO.getDireccionIp());
        clientModel.setTipoCliente(createClientDTO.getTipoClienteModel());
        clientModel.setTelefonoContacto(createClientDTO.getTelefonoContacto());

        return clientModel;
    }
}