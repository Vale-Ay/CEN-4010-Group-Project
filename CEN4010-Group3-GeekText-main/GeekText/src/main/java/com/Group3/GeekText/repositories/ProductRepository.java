package com.Group3.GeekText.repositories;


import com.Group3.GeekText.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long > {

    List<Product> findAllByUserId(long userId);
    Product findByUserIdAndBookId(long userId, int bookId);

}
