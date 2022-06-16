package com.example.shop24.services;

import com.example.shop24.dtos.DetailsDto;
import com.example.shop24.models.Details;
import com.example.shop24.models.Order;

import java.util.List;

public interface DetailsService {
    Details saveDetails(DetailsDto dto, Order order) throws Exception;
}
