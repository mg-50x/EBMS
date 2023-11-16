package com.eightbit.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eightbit.books.entity.Book_master;
import com.eightbit.books.entity.Books;

public interface Book_masterRepository extends JpaRepository<Book_master, Long>{
	List<Book_master> findByTitleContaining(String bookName);

	List<Book_master> findByAuthorContaining(String authName);

	List<Book_master> findAllByOrderByTitleAsc();

	Book_master findByBookId(int bookId);
}
