package com.Library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Library.entity.Author;
import com.Library.entity.Book;

public interface AuthorService {
	
	    Author save(Author author);
	    List<Author> findAll();
	    void deleteById(Integer id);
		Optional<Author> findById(Integer id);	
		Author updateAutoreById(Integer id, Author autor);
}
