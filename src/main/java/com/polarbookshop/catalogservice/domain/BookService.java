package com.polarbookshop.catalogservice.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    public final BookRepository bookRepository;

    public Iterable<Book> viewBookList(){
        return bookRepository.findAll();
    }

    public Book viewBookDetail(String isbn){
        return bookRepository.findBookByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }
    public Book addBookToCatalog(Book book){
        if (bookRepository.findBookByIsbn(book.isbn()).isPresent()){
            throw new BookAlreadyExistException(book.isbn());
        }
        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(String isbn){
        bookRepository.deleteBookByIsbn(isbn);
    }

    public Book editeBookDetails(String isbn, Book book){
        return bookRepository.findBookByIsbn(isbn)
                .map(existingBook -> {
                    var bookToUpdate = Book.of(
                            isbn,
                            book.title(),
                            book.author(),
                            book.price()
                    );
                    return bookRepository.save(bookToUpdate);
                }).orElseGet(() -> addBookToCatalog(book));
    }
}
