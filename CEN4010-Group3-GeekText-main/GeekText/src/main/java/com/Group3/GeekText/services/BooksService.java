package com.Group3.GeekText.services;

import com.Group3.GeekText.entities.Books;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public interface BooksService {
    List<Books> findAll();
    List<Books> getBooksByBookGenre(String bookGenre);
    List<Books> getBooksByBookAuthor(String bookAuthor);
    List<Books> findBookByIsbn(String ISBN);
    List<Books> getBooksByBookRatings(String bookRatings);
    List<Books> updateBookPriceByBookPublisher(String bookPublisher, double discountPercent);

}
