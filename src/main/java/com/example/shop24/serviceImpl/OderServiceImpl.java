package com.example.shop24.serviceImpl;

import com.example.shop24.dtos.DetailsDto;
import com.example.shop24.dtos.OrderDto;
import com.example.shop24.enums.EStatus;
import com.example.shop24.exceptions.ResourceNotFoundException;
import com.example.shop24.models.Cargo;
import com.example.shop24.models.Order;
import com.example.shop24.models.Client;
import com.example.shop24.repositories.OrderRepository;
import com.example.shop24.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final CargoServiceImpl cargoService;

    private final DetailServiceImpl detailsService;

    private final ClientServiceImpl userService;

    public OderServiceImpl(OrderRepository orderRepository, CargoServiceImpl cargoService, DetailServiceImpl detailsService, ClientServiceImpl userService) {
        this.orderRepository = orderRepository;
        this.cargoService = cargoService;
        this.detailsService = detailsService;
        this.userService = userService;
    }

    @Override
    public Order createNewOrder(OrderDto dto) throws Exception {
        Cargo cargo = cargoService.findById(dto.getCargo());
        Client client = userService.findById(dto.getClient());
        Order order = new Order();
        order.setAmount(order.getAmount());
        order.setCargo(cargo);
        order.setClient(client);
        Order saved =  orderRepository.save(order);

        for(DetailsDto detailsDto: dto.getDetails()){
            detailsService.saveDetails(detailsDto, saved);
        }

        return saved;
    }

    @Override
    public List<Order> getTop5Orders() {
        return orderRepository.findTopFive();
    }

    @Override
    public List<Order> getOrderDetails() {
        return orderRepository.findTopTenPaid();
    }

    @Override
    public Order completeOrder(UUID orderId) throws ResourceNotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        order.setStatus(EStatus.DELIVERED);
        return orderRepository.save(order);
    }
}
