package greet.service;

import greet.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void addBook(Book book);
    void deleteBook(String isbn);
    Optional<Book> getBook(String isbn);
    List<Book> getAllBooks();
}
