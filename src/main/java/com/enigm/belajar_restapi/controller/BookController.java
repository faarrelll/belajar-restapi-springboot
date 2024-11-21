package com.enigm.belajar_restapi.controller;

import com.enigm.belajar_restapi.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.enigm.belajar_restapi.constant.Constant;
import com.enigm.belajar_restapi.dto.Request;
import com.enigm.belajar_restapi.dto.Respond;
import com.enigm.belajar_restapi.service.BookService;
import com.enigm.belajar_restapi.utils.RespondUtils;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;


@RequestMapping(Constant.API)
@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Respond> allBook = bookService.getAllBook();
        return RespondUtils.buildResponse(HttpStatus.OK, "Succes Get data", allBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        Respond book = bookService.getBookById(uuid);
        return RespondUtils.buildResponse(HttpStatus.OK, "Succes Get data", book);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Request entity) {
        Respond data = bookService.createBook(entity);
        return RespondUtils.buildResponse(HttpStatus.CREATED, "Succes Created Book", data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody Request entity) {
        UUID uuid = UUID.fromString(id);
        Respond updatedBook = bookService.updateMenu(uuid, entity);
        return RespondUtils.buildResponse(HttpStatus.OK, "Succes Updated Book", updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        bookService.deleteBook(uuid);
        return RespondUtils.buildResponse(HttpStatus.OK, "Succes Deleted Book", uuid);
    }

    
}
