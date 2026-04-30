package com.josel.spring_shop.DTO.orderDTO;

import com.josel.spring_shop.DTO.itemDTO.ItempMapper;
import com.josel.spring_shop.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderMapper {

    private final ItempMapper itemMapper;

    public OrderResponseDTO toDTO(Order order) {
        return OrderResponseDTO.builder()
                .id(order.getId())
                .items(order.getItems().stream()
                        .map(itemMapper::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}