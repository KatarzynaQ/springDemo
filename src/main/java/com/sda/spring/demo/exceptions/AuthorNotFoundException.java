package com.sda.spring.demo.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {
        super("nie ma takiego autora");
    }
}
