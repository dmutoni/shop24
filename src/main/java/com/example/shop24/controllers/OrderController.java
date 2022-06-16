package com.example.shop24.controllers;

import com.example.shop24.dtos.OrderDto;
import com.example.shop24.dtos.ResponseDto;
import com.example.shop24.exceptions.ResourceNotFoundException;
import com.example.shop24.models.Order;
import com.example.shop24.serviceImpl.OderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RestController("/orders")
public class OrderController {
    private final OderServiceImpl orderService;

    public OrderController(OderServiceImpl orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/top-five")
    public ResponseEntity<ResponseDto> getTopFive() {
        List<Order> orders = orderService.getTop5Orders();
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched orders", orders), HttpStatus.OK);
    }

    @GetMapping("/top-ten/paid")
    public ResponseEntity<ResponseDto> getTenPaid() {
        List<Order> order = orderService.getOrderDetails();
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched drinks", order), HttpStatus.OK);
    }

    @PostMapping("/complete-order/:id")
    public ResponseEntity<ResponseDto> completeOrder(@PathVariable UUID id) throws ResourceNotFoundException {
        Order order = orderService.completeOrder(id);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched drinks", order), HttpStatus.OK);
    }

    @PostMapping("/save-order")
    public ResponseEntity<ResponseDto> saveOrder(@RequestBody OrderDto dto) throws Exception {
        Order order = orderService.createNewOrder(dto);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched drinks", order), HttpStatus.OK);
    }
}
