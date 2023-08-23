package com.Group3.GeekText.controllers;

import com.Group3.GeekText.entities.Books;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Group3.GeekText.repositories.BooksRepository;
import com.Group3.GeekText.services.BooksService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.*;

@RestController
@RequestMapping("/")

public class BooksController {
    @Autowired
    private BooksService booksService;
    private final BooksRepository booksRepository;

    public BooksController(BooksService booksService, BooksRepository booksRepository) {
        this.booksService = booksService;
        this.booksRepository = booksRepository;
    }

    @GetMapping("/getAllBooks")
    public List<Books> getBooks() {
        return booksService.findAll();
    }

    @GetMapping("/byIsbn/{ISBN}")
    public List<Books> getBookByIsbn(@PathVariable("ISBN") String ISBN){
        List<Books> isbnSearch = booksService.findBookByIsbn(ISBN);
        return isbnSearch;
    }

    @GetMapping("/genre/{bookGenre}")
    public List<Books> getBooksByBookGenre(@PathVariable String bookGenre){
        return booksService.getBooksByBookGenre(bookGenre);
    }

    @GetMapping("/rating/{bookRatings}")
    public List<Books> getBooksByBookRatings(@PathVariable String bookRatings){
        return booksService.getBooksByBookRatings(bookRatings);
    }

    @GetMapping("/books/{bookAuthor}")
    public List<Books> getBooksByBookAuthor(@PathVariable String bookAuthor){
        return booksService.getBooksByBookAuthor(bookAuthor);
    }

    @PostMapping("/books")
    public void createBook(@RequestBody Books books) {
        booksRepository.save(books);
    }

    @GetMapping("/top10")
    public List<Books> getTop10SoldBooks(){
        Pageable pageable = PageRequest.of(0, 10);
        return booksRepository.findTop10SoldBooks(pageable);
    }

    @PutMapping("/updatePrice/{bookPublisher}")
    public ResponseEntity<String> updateBookPriceByBookPublisher(@PathVariable String bookPublisher, @RequestParam double discountPercent) {
        try {
            List<Books> updatedBooks = booksService.updateBookPriceByBookPublisher(bookPublisher, discountPercent);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(updatedBooks);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(json, headers, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update book prices: " + e.getMessage());
        }
    }


}
