package com.Group3.GeekText.services.Impl;


import com.Group3.GeekText.entities.Books;
import com.Group3.GeekText.entities.Product;
import com.Group3.GeekText.repositories.BooksRepository;
import com.Group3.GeekText.repositories.ProductRepository;
import com.Group3.GeekText.repositories.ProfilesRepository;
import com.Group3.GeekText.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final BooksRepository booksRepository;

    private final ProfilesRepository profilesRepository;

    public ProductServiceImpl(ProductRepository productRepository, BooksRepository booksRepository, ProfilesRepository profilesRepository){
        this.productRepository = productRepository;
        this.booksRepository = booksRepository;
        this.profilesRepository = profilesRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Books> getProductsByUserId(long userId) {
        List<String> bookIds = productRepository.findAllByUserId(userId).stream().map(x-> String.valueOf(x.getBookId())).toList();
        return (List<Books>) booksRepository.findAllById(bookIds);
    }

    @Override
    public void addItemToCart(Long userId, int bookId) throws Exception {
        profilesRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
        booksRepository.findById(String.valueOf(bookId)).orElseThrow(() -> new Exception("Book not found"));

        Product product = productRepository.findByUserIdAndBookId(userId, bookId);
        if (product != null) {
            product.setQuantity(product.getQuantity() + 1);
        } else {
            product = Product.builder()
                    .userId(userId)
                    .quantity(1)
                    .bookId(bookId)
                    .build();
        }
        productRepository.save(product);

    }


    @Override
    public double getSubtotalPrice(long userId) {
         List<Product> products = productRepository.findAllByUserId(userId);

        Map<String, Double> bookPrices = booksRepository.findAll().stream()
                .collect(Collectors.toMap(Books::getBookID, Books::getBookPrice));

         double subtotal = 0;
         for (Product product : products ){
             subtotal += (product.getQuantity() * bookPrices.getOrDefault(String.valueOf(product.getBookId()), 0.00));
         }
         return subtotal;
    }

    @Override
    public void deleteBookFromCart(Long userId, int bookId) throws Exception {
        profilesRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
        booksRepository.findById(String.valueOf(bookId)).orElseThrow(() -> new Exception("Book not found"));

        Product product = productRepository.findByUserIdAndBookId(userId, bookId);
        if(product.getQuantity() > 1) {
            product.setQuantity(product.getQuantity() - 1);
            productRepository.save(product);
        }else{
            productRepository.delete(product);
        }




    }

}
