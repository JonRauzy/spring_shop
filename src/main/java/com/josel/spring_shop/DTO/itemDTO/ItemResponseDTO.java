package com.josel.spring_shop.DTO.itemDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {
    private Long id;
    private String name;
    private int quantity;
}
