package com.enigm.belajar_restapi.service;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.enigm.belajar_restapi.dto.Request;
import com.enigm.belajar_restapi.dto.Respond;
import com.enigm.belajar_restapi.entity.Book;
import com.enigm.belajar_restapi.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Override
    public Respond createBook(Request bookRequest) {
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
    public Respond updateMenu(UUID id, Request bookRequest) {
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
    public List<Respond> getAllBook() {
        List<Respond> bookResponds = new ArrayList<>();
        bookRepository.findAll().forEach(v-> bookResponds.add(convert(v)));
        return bookResponds;
    }

    @Override
    public Respond getBookById(UUID id) {
        Optional<Book> book = bookRepository.findById(id);
        return convert(book.get());
    }

    public Respond convert(Book book){
        Respond respond = Respond.builder()
                            .bookName(book.getBookName())
                            .quantity(book.getQuantity())
                            .build();
        return respond;
    }


}
