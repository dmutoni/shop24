package com.example.shop24.services;

import com.example.shop24.dtos.OrderDto;
import com.example.shop24.exceptions.ResourceNotFoundException;
import com.example.shop24.models.Details;
import com.example.shop24.models.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Order createNewOrder(OrderDto dto) throws Exception;
    List<Order> getTop5Orders();
    List<Order> getOrderDetails();
    Order completeOrder(UUID orderId) throws ResourceNotFoundException;
}
