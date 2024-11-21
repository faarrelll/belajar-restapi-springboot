package com.enigm.belajar_restapi.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.enigm.belajar_restapi.dto.CommonRespond;

public class RespondUtils {
    public static <T> ResponseEntity<CommonRespond<T>> buildResponse(HttpStatus status, String message, T data) {
        CommonRespond<T> response = new CommonRespond<>(status.value(), message, data);
        return ResponseEntity.status(status).body(response);
    }
}
