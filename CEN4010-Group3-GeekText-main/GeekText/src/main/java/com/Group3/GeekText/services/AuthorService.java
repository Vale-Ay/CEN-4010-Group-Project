package com.Group3.GeekText.services;

import java.util.*;
import com.Group3.GeekText.entities.Author;
import com.Group3.GeekText.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Group3.GeekText.entities.Profile;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

}