package com.enigm.belajar_restapi.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Book {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Column(nullable=false)
    private String bookName;
    
    @Column(nullable=false)
    private Integer quantity;


    
}
