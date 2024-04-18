package com.polarbookshop.catalogservice.domain;

public class BookAlreadyExistException extends RuntimeException{

    public BookAlreadyExistException(String isbn){
        super("The book with the ISBN " + isbn + " already exist.");
    }
}
