package com.josel.spring_shop.service;

import com.josel.spring_shop.DTO.itemDTO.ItemRequestDTO;
import com.josel.spring_shop.DTO.itemDTO.ItemResponseDTO;
import com.josel.spring_shop.DTO.itemDTO.ItempMapper;
import com.josel.spring_shop.exception.ItemNotFoundException;
import com.josel.spring_shop.model.Item;
import com.josel.spring_shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItempMapper itemMapper;

    public List<ItemResponseDTO> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ItemResponseDTO findById(Long id) {
        Item item = getOrThrow(id);
        return itemMapper.toDTO(item);
    }

    public ItemResponseDTO create(ItemRequestDTO dto) {
        if (dto.getQuantity() < 1) {
            throw new IllegalArgumentException("Quantity must be >= 1");
        }

        Item item = itemMapper.toEntity(dto);
        Item savedItem = itemRepository.save(item);

        return itemMapper.toDTO(savedItem);
    }

    public ItemResponseDTO update(Long id, ItemRequestDTO dto) {
        if (dto.getQuantity() < 1) {
            throw new IllegalArgumentException("Quantity must be >= 1");
        }

        Item item = getOrThrow(id);

        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());

        Item updatedItem = itemRepository.save(item);

        return itemMapper.toDTO(updatedItem);
    }

    public void delete(Long id) {
        Item item = getOrThrow(id);
        itemRepository.delete(item);
    }

    Item getOrThrow(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);

        if (optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            throw new ItemNotFoundException(id);
        }
    }
}