package com.josel.spring_shop.DTO.itemDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDTO {
    private String name;
    private int quantity;
}
