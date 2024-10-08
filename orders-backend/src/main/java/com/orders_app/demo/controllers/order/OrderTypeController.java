package com.orders_app.demo.controllers.order;

import com.orders_app.demo.DTO.client.ResponseClientDTO;
import com.orders_app.demo.models.OrderTypeModel;
import com.orders_app.demo.services.order.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order-type")
public class OrderTypeController {
    @Autowired
    private OrderTypeService orderTypeService;
    @GetMapping
    private ResponseEntity<List<OrderTypeModel>> getAllOrderTypes(){
        try{
            List<OrderTypeModel> orderTypes = orderTypeService.findOrderTypes();
            if (orderTypes.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(orderTypes);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
