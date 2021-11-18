package com.sahuyash.Book.service;


import com.sahuyash.Book.controller.BookException;
import com.sahuyash.Book.dao.BookRepository;
import com.sahuyash.Book.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired, @Lazy}))
public class BookService {

    private final BookRepository repository;

    public Collection<Book> getAll() {
        return repository.findAll();
    }

    public Book addBook(Book theBook) {
        return repository.save(theBook);
    }

    public Book updateBook(Book theBook) {
        return repository.save(theBook);
    }

    public void deleteBook(int bookId) {
        final Book book = repository.findById(bookId).orElseThrow(() -> new BookException("Book not available"));
        repository.delete(book);
    }
}
