package com.eightbit.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eightbit.books.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

	public List<Books> findByBookMasterBookId(int bookId);
}
