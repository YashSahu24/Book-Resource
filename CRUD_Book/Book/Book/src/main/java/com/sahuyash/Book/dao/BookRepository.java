package com.sahuyash.Book.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sahuyash.Book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
             
	@Query("select s from Book s where s.author like %?1%"
	        +"OR s.title like %?1%"
	        +"OR s.gender like %?1%"
	        +"OR s.price like %?1%"
	        +"OR s.country like %?1%")
		public Page<Book> findBy(String search,Pageable pageable);
}
