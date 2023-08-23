package com.Group3.GeekText.controllers;

import com.Group3.GeekText.entities.Books;
import com.Group3.GeekText.services.AuthorService;
import com.Group3.GeekText.entities.Author;
import com.Group3.GeekText.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/getAllAuthors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping("/addAuthor")
    public void createAuthor(@RequestBody Author author) {
        authorRepository.save(author);
    }

}
