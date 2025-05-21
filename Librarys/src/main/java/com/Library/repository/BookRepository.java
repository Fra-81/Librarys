package com.Library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Library.entity.Book;



public interface BookRepository extends CrudRepository<Book, Integer> {
	// Metodo derivato
		public boolean existsByTitle(String title);
		Optional<Book> findByTitle(String title);
		List<Book> findByGenre(String genre);
}
