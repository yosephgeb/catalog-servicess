package com.polarbookshop.catalogservice.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Long> {

    Optional<Book> findBookByIsbn(String isbn);

    void deleteBookByIsbn(String isbn);
}
