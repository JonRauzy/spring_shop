package com.josel.spring_shop.controller;

import com.josel.spring_shop.DTO.orderDTO.OrderRequestDTO;
import com.josel.spring_shop.DTO.orderDTO.OrderResponseDTO;
import com.josel.spring_shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResponseDTO> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderResponseDTO getById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDTO create(@RequestBody OrderRequestDTO dto) {
        return orderService.create(dto);
    }

    @PutMapping("/{id}")
    public OrderResponseDTO update(@PathVariable Long id, @RequestBody OrderRequestDTO dto) {
        return orderService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}