package com.Library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.entity.Author;
import com.Library.entity.Book;
import com.Library.repository.AuthorRepository;
@Service 
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	private AuthorRepository authorRepository ;
	
	
	@Override
	public Author save(Author author) {
		if(author== null) {
			throw new IllegalArgumentException("Author cannot ne null");
		}
		return authorRepository.save(author);
	}

	@Override
	public Optional<Author> findById(Integer id) {
	
		return authorRepository.findById(id);
	}

	@Override
	public List<Author> findAll() {
		
		return (List<Author>) authorRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		authorRepository.deleteById(id);
		
	}

	@Override
	public Author updateAutoreById(Integer id, Author autor) {
		Optional<Author> autore = authorRepository.findById(id);
		if (autore == null) {
			throw new IllegalArgumentException("Author cannot be null");
		}
		if (autore.isPresent()) {
			Author a = autore.get();
			a.setName(a.getName());
			a.setCognome(a.getCognome());
			
			return authorRepository.save(a);
		} else {
			throw new IllegalArgumentException("l'autore con ID " + id + " non trovato");
		}
	}
		

}
