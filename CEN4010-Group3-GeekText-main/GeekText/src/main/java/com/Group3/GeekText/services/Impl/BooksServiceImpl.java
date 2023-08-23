package com.Group3.GeekText.services.Impl;

import com.Group3.GeekText.entities.Books;
import com.Group3.GeekText.repositories.BooksRepository;
import com.Group3.GeekText.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class  BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Override
    public List<Books> getBooksByBookGenre(String bookGenre) {
        return booksRepository.findByBookGenre(bookGenre);
    }

    @Override
    public List<Books> findAll() {
        return booksRepository.findAll();
    }
    @Override
    public List<Books> getBooksByBookRatings(String bookRatings){
        return booksRepository.findByBookRatingsGreaterThanEqual(bookRatings);
    }
    @Override
    public List<Books> findBookByIsbn(String ISBN) {
        return booksRepository.findBookByIsbn(ISBN);
    }

    @Override
    public List<Books> getBooksByBookAuthor(String bookAuthor) {
        return booksRepository.findByBookAuthor(bookAuthor);
    }

    @Override
    public List<Books> updateBookPriceByBookPublisher(String bookPublisher, double discountPercent) {
        List<Books> books = booksRepository.findByBookPublisher(bookPublisher);
        for (Books book : books) {
            double currentBookPrice = book.getBookPrice();
            double discount = currentBookPrice * discountPercent / 100;
            double updatedBookPrice = currentBookPrice - discount;
            book.setBookPrice(updatedBookPrice);
        }

        booksRepository.saveAll(books);
        return books;
    }




}
