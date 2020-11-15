package com.sahuyash.Book.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sahuyash.Book.entity.Book;


public interface BookService {

    public List<Book> findAll();
	
	public Book findById(int theId);
	
	public void save(Book theEmployee);
	
	public void deleteById(int theId);
	
	public Page<Book> findBy(String search,Pageable pageable);
}
