package com.josel.spring_shop.DTO.itemDTO;

import com.josel.spring_shop.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItempMapper {
    public ItemResponseDTO toDTO(Item i)
    {
        ItemResponseDTO dto = new ItemResponseDTO();
        dto.setId(i.getId());
        dto.setName(i.getName());
        dto.setQuantity(i.getQuantity());
        return dto;
    }

    public Item toEntity(ItemRequestDTO dto)
    {
        Item i = new Item();
        i.setName(dto.getName());
        i.setQuantity(dto.getQuantity());
        return i;
    }
}
