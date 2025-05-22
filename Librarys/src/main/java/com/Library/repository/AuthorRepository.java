package com.Library.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Library.entity.Author;
import com.Library.entity.Book;

public interface AuthorRepository  extends CrudRepository<Author, Integer>{
	
	
	

}
