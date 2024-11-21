package com.enigm.belajar_restapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigm.belajar_restapi.entity.Book;

public interface  BookRepository extends JpaRepository<Book, UUID>{
    
}
