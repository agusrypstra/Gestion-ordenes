package com.orders_app.demo.services;

import com.orders_app.demo.DTO.client.CreateClientDTO;
import com.orders_app.demo.DTO.client.ResponseClientDTO;
import com.orders_app.demo.mappers.ClientMapper;
import com.orders_app.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ResponseClientDTO> findAllClients(){
        return clientRepository.findAll().stream()
                .map(ClientMapper::toResponseDTO)  // Usa el mapper
                .collect(Collectors.toList());
    }
}
