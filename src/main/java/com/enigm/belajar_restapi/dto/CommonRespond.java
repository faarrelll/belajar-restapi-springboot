package com.enigm.belajar_restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CommonRespond <T> {
    private Integer statusCode;
    private String message;
    private T data;
}
