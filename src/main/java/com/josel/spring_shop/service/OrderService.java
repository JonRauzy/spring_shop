package com.josel.spring_shop.service;

import com.josel.spring_shop.DTO.orderDTO.OrderMapper;
import com.josel.spring_shop.DTO.orderDTO.OrderRequestDTO;
import com.josel.spring_shop.DTO.orderDTO.OrderResponseDTO;
import com.josel.spring_shop.exception.OrderNotFoundException;
import com.josel.spring_shop.model.Item;
import com.josel.spring_shop.model.Order;
import com.josel.spring_shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ItemService itemService;

    public List<OrderResponseDTO> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OrderResponseDTO findById(Long id) {
        return orderMapper.toDTO(getOrThrow(id));
    }

    public OrderResponseDTO create(OrderRequestDTO dto) {
        Order order = new Order();
        order.setItems(resolveItems(dto));
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public OrderResponseDTO update(Long id, OrderRequestDTO dto) {
        Order order = getOrThrow(id);
        order.setItems(resolveItems(dto));
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public void delete(Long id) {
        orderRepository.delete(getOrThrow(id));
    }

    private Order getOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    private List<Item> resolveItems(OrderRequestDTO dto) {
        if (dto.getItems() == null || dto.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        return dto.getItems()
                .stream()
                .map(itemService::create)
                .map(response -> itemService.getOrThrow(response.getId()))
                .collect(Collectors.toList());
    }
}