package com.Library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.entity.Book;
import com.Library.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> findAllBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Optional<Book> findBookById(Integer id) {
		return bookRepository.findById(id);
	}

	@Override
	public Optional<Book> findBookByTitle(String title) {
		if(title == null) {
			throw new IllegalArgumentException("Book error");
		}
		return bookRepository.findByTitle(title);
	}

	@Override
	public List<Book> findBooksByGenre(String genre) {
		
		return bookRepository.findByGenre(genre);
	}

	@Override
	public List<String> findAllGenres() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Book saveBook(Book book) {
		if(book == null) {
			throw new IllegalArgumentException("Book cannot ne null");
		}
		if(bookRepository.existsByTitle(book.getTitle())) {
			throw new IllegalArgumentException("Book error");
		}
		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(Integer id) {
		 bookRepository.deleteById(id);
		
	}

	@Override
	public Book updateBookById(Integer id, Book book) {
		// TODO Auto-generated method stub
		return null;
	}

}
