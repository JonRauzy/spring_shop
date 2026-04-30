package com.josel.spring_shop.DTO.orderDTO;
import com.josel.spring_shop.DTO.itemDTO.ItemRequestDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {
    private List<ItemRequestDTO> items;
}
