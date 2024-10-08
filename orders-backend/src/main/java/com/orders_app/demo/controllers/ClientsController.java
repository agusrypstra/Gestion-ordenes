package com.orders_app.demo.controllers;

import com.orders_app.demo.DTO.client.CreateClientDTO;
import com.orders_app.demo.DTO.client.ResponseClientDTO;
import com.orders_app.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ResponseClientDTO>> getAllClients(){
        try{
            List<ResponseClientDTO> clients = clientService.findAllClients();
            if (clients.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(clients);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
