package com.josel.spring_shop.controller;

import com.josel.spring_shop.DTO.itemDTO.ItemRequestDTO;
import com.josel.spring_shop.DTO.itemDTO.ItemResponseDTO;
import com.josel.spring_shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemResponseDTO> getAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ItemResponseDTO getById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponseDTO create(@RequestBody ItemRequestDTO dto) {
        return itemService.create(dto);
    }

    @PutMapping("/{id}")
    public ItemResponseDTO update(@PathVariable Long id, @RequestBody ItemRequestDTO dto) {
        return itemService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        itemService.delete(id);
    }
}
