package com.polarbookshop.catalogservice.domain;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String isbn){
        super("The book with the ISBN " + isbn + " is not found");
    }
}
