package com.enigm.belajar_restapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookRespond {
    
    private String bookName;

    private Integer quantity;
}
