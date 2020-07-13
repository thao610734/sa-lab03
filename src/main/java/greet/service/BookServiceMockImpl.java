package greet.service;

import greet.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public class BookServiceMockImpl implements BookService {

    static List<Book> store;
    static {
        store = new ArrayList<>();
        store.add(new Book("123", "Book 1", 12.4, "Jame Bond"));
        store.add(new Book("456", "Book 2", 13.3, "Mary Land"));
    }

    @Override
    public void addBook(Book book) {
        store.add(book);
    }

    @Override
    public void deleteBook(String isbn) {
        store.removeIf(e ->  e.getIsbn().equalsIgnoreCase(isbn));
    }

    @Override
    public Optional<Book> getBook(String isbn) {
        return store.stream().filter(e -> e.getIsbn().equalsIgnoreCase(isbn)).findFirst();
    }

    @Override
    public List<Book> getAllBooks() {
        return store;
    }
}
