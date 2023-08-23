package com.Group3.GeekText.controllers;



import com.Group3.GeekText.entities.Product;
import com.Group3.GeekText.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shopping-cart")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;

    }


    @GetMapping("get-all-products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("{user-id}")
    public ResponseEntity getProductById(@PathVariable("user-id") long UserId){
        return ResponseEntity.ok(productService.getProductsByUserId(UserId));
    }

    @GetMapping("{user-id}/subtotal")
    public ResponseEntity getSubtotalPriceByUserId(@PathVariable("user-id") long UserId) {
        try {
            return ResponseEntity.ok(productService.getSubtotalPrice(UserId));
        } catch(Exception e) {
            return ResponseEntity.status(500).body(String.format("Error occurred: %s", e.getMessage()));
        }
    }

    @PostMapping()
    public ResponseEntity<String> addToCart(@RequestParam("user-id") long userId, @RequestParam("book-id") int bookId ) {
        try {
            productService.addItemToCart(userId, bookId);
            return ResponseEntity.ok().build();
        } catch(Exception e) {
            return ResponseEntity.status(500).body(String.format("Error occurred: %s", e.getMessage()));
        }
    }
@DeleteMapping("delete-product/{userId}/{bookId}")
    public  ResponseEntity<String> removeBookFromCart(@PathVariable("userId") long userId, @PathVariable("bookId") int bookId){
        try {
            productService.deleteBookFromCart(userId, bookId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(500).body(String.format("Error occurred: %s", e.getMessage()));
        }
    }


}
