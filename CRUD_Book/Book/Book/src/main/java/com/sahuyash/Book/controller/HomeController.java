package com.sahuyash.Book.controller;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahuyash.Book.entity.Book;
import com.sahuyash.Book.service.BookService;


@RestController
@RequestMapping("/api")
public class HomeController {

private BookService bookService;
	
	@Autowired
	public HomeController(BookService theBookService) {
		bookService = theBookService;
	}
	
	@GetMapping("/books")
	public Page<Book> findAll(@RequestParam Optional<String> search,
			                  @RequestParam Optional<Integer> page,
			                  @RequestParam Optional<String> sortBy,
			                  @RequestParam Optional<String> dir) { 
		return bookService.findBy(search.orElse("_"),
				                  PageRequest.of(page.orElse(0),
				                		         10,
				                		         Sort.Direction.fromString(dir.orElse("asc")),
				                		         sortBy.orElse("bid")));
	}

	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable int bookId) {
		
		Book theBook = bookService.findById(bookId);
		
		if (theBook == null) {
			throw new BookException("Book id not found - " + bookId);
		}
		
		return theBook;
	}
	
	@PatchMapping("/books/{bid}")
	public @ResponseBody Book saveBook(@PathVariable int bid,
			                            @RequestBody Map<Object,Object> map)
	{
		Book book=bookService.findById(bid);
		map.forEach((k,v)->  {
		        Field field = ReflectionUtils.findField(Book.class, (String)k);
		        field.setAccessible(true);
		        ReflectionUtils.setField(field, book, v);
		});
		bookService.save(book);
		return book;
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book theBook) {
		
		theBook.setBid(0);;
		
		bookService.save(theBook);
		
		return theBook;
	}
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book theBook) {
		
		bookService.save(theBook);
		
		return theBook;
	}
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		
		Book temp = bookService.findById(bookId);
			
		if (temp == null) {
			throw new BookException("Employee id not found - " + bookId);
		}
		
		bookService.deleteById(bookId);
		
		return "Deleted employee id - " + bookId;
	}
	
	
}
