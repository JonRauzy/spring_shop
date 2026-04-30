package com.josel.spring_shop.DTO.orderDTO;

import com.josel.spring_shop.DTO.itemDTO.ItemResponseDTO;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {
    private Long                    id;
    private List<ItemResponseDTO> items;}
