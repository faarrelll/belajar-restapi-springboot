package com.enigm.belajar_restapi.service;

import java.util.List;
import java.util.UUID;

import com.enigm.belajar_restapi.dto.BookRequest;
import com.enigm.belajar_restapi.dto.BookRespond;

public interface BookService {

    BookRespond createBook(BookRequest bookRequest);
    BookRespond updateMenu(UUID id, BookRequest bookRequest);
    void deleteBook(UUID id);
    List<BookRespond> getAllBook(String name);
    BookRespond getBookById(UUID id);


}
