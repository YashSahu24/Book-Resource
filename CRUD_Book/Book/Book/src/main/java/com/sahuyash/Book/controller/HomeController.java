package com.sahuyash.Book.controller;

import com.sahuyash.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahuyash.Book.entity.Book;

import java.util.Collection;


@RestController
@RequestMapping("/api")
public class HomeController {

private BookService bookService;
	
	@Autowired
	public HomeController(BookService theBookService) {
		bookService = theBookService;
	}
	
	@GetMapping("/books")
	public Collection<Book> findAll() {
		return bookService.getAll();
	}

	@PostMapping("/book")
	public Book addBook(@RequestBody Book theBook) {
		return bookService.addBook(theBook);
	}
	
	@PutMapping("/book")
	public Book updateBook(@RequestBody Book theBook) {
		return bookService.updateBook(theBook);
	}
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
		return "Book id: "+bookId+" is deleted from database";
	}
	
}
