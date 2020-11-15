package com.sahuyash.Book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sahuyash.Book.dao.BookRepository;
import com.sahuyash.Book.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	
	
	@Autowired
	public BookServiceImpl(BookRepository theBookRepository) {
		bookRepository = theBookRepository;
	}
	
	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);
		Book theEmployee = null;
		if (result.isPresent()) 
		{
			theEmployee = result.get();
		}
		else
		{
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Book theBook) {
		bookRepository.save(theBook);	}

	@Override
	public void deleteById(int theId) {
		bookRepository.deleteById(theId);
	}

	@Override
	public Page<Book> findBy(String search,Pageable pageable) {
		return bookRepository.findBy(search,pageable);
	}

	

}
