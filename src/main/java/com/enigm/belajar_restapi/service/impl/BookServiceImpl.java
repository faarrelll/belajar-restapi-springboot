package com.enigm.belajar_restapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.enigm.belajar_restapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.enigm.belajar_restapi.dto.BookRequest;
import com.enigm.belajar_restapi.dto.BookRespond;
import com.enigm.belajar_restapi.entity.Book;
import com.enigm.belajar_restapi.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookRespond createBook(BookRequest bookRequest) {
        System.out.println(bookRequest.getBookName());
        System.out.println(bookRequest.getQuantity());
        Book newBook = Book.builder()
                        .bookName(bookRequest.getBookName())
                        .quantity(bookRequest.getQuantity())
                        .build();
        bookRepository.saveAndFlush(newBook);

        return convert(newBook);
    }

    @Override
    public BookRespond updateMenu(UUID id, BookRequest bookRequest) {
       Book book = bookRepository.findById(id).get();
       book.setBookName(bookRequest.getBookName());
       book.setQuantity(bookRequest.getQuantity());
       bookRepository.saveAndFlush(book);
       return convert(book);
    }

    @Override
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookRespond> getAllBook(String search) {
        List<BookRespond> bookBookResponds = new ArrayList<>();
        if(search == null || search.isEmpty()) {
           bookRepository.findAll().forEach(v-> bookBookResponds.add(convert(v)));
        } else{
           bookBookResponds.add(bookRepository.findByBookName(search));


        }
        return bookBookResponds;
    }

    @Override
    public BookRespond getBookById(UUID id) {
        Optional<Book> book = bookRepository.findById(id);
        return convert(book.get());
    }

    public BookRespond convert(Book book){
        BookRespond bookRespond = BookRespond.builder()
                            .bookName(book.getBookName())
                            .quantity(book.getQuantity())
                            .build();
        return bookRespond;
    }


}
