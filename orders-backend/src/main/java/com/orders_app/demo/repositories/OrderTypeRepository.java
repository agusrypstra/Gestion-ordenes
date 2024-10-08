package com.orders_app.demo.repositories;

import com.orders_app.demo.models.OrderTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTypeRepository extends JpaRepository<OrderTypeModel,Long> {
}
