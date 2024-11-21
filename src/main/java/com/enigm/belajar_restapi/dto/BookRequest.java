package com.enigm.belajar_restapi.dto;

import lombok.Data;

@Data
public class BookRequest {

    private String bookName;

    private Integer quantity;
    
}
