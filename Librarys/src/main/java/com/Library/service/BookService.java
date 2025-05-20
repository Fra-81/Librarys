package com.Library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Library.entity.Book;
import com.Library.entity.Book.genre;

@Service
public interface BookService {
	public List<Book> findAllBooks();
	public Optional<Book> findBookById(Integer id);
	public Optional<Book> findBookByTitle(String title);
	public List<Book> findBooksByGenre(String genre);
	public List<String> findAllGenres();
	public Book saveBook(Book book);
	public void deleteBookById(Integer id);
	public Book updateBookById(Integer id, Book book);
	
	//ENUM
	public List<genre> allGenreEnum();

}
