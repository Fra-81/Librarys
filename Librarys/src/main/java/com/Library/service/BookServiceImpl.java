package com.Library.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.entity.Book;
import com.Library.entity.Book.genre;
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

		return bookRepository.findAllGenres();
	}



	@Override
	public Book saveBook(Book book) {
		if(book == null) {
			throw new IllegalArgumentException("Book cannot ne null");
		}
		if(book.getTitle()=="") {
			throw new IllegalArgumentException("Book cannot ne empty");
		}
		if(bookRepository.existsByTitle(book.getTitle())) {
			throw new IllegalArgumentException("Book error");
		}
		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(Integer id) {
		if(bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
		}else {
			throw new IllegalArgumentException("Il libro con ID " + id + " non esiste");
		}

	}

	@Override
	public Book updateBookById(Integer id, Book book) {
		Optional<Book> books = bookRepository.findById(id);

		if (book == null) {
			throw new IllegalArgumentException("Book cannot be null");
		}
		if (books.isPresent()) {
			Book a = books.get();
			a.setTitle(book.getTitle());
			a.setGenre(book.getGenre());
			a.setPrice(book.getPrice());
			return bookRepository.save(a);
		} else {
			throw new IllegalArgumentException("Il libro con ID " + id + " non trovato");
		}
	}
	
	// questo con l'enum, dati genre fissi 
	public List<genre> allGenreEnum(){
		return  Arrays.asList(genre.values());
	}
}
