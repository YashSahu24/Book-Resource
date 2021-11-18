package com.sahuyash.Book.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sahuyash.Book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
