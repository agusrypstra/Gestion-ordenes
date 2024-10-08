package com.orders_app.demo.services.order;

import com.orders_app.demo.models.OrderTypeModel;
import com.orders_app.demo.repositories.OrderTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTypeService {
    @Autowired
    private OrderTypeRepository orderTypeRepository;
    public List<OrderTypeModel> findOrderTypes(){
        return orderTypeRepository.findAll();
    }
}
