package com.enigm.belajar_restapi.service;

import java.util.List;
import java.util.UUID;

import com.enigm.belajar_restapi.dto.Request;
import com.enigm.belajar_restapi.dto.Respond;

public interface BookService {

    Respond createBook(Request bookRequest);
    Respond updateMenu(UUID id, Request bookRequest);
    void deleteBook(UUID id);
    List<Respond> getAllBook();
    Respond getBookById(UUID id);


}
