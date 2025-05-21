package com.Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library.entity.Book;
import com.Library.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {
	@Autowired 
	private BookService bookService;

	@GetMapping("/public/books")
	public ResponseEntity<Object> getAllBooks() {
		List<Book> books = bookService.findAllBooks();
		if (!books.isEmpty()) {
			return new ResponseEntity<>(books, HttpStatus.OK);
		}
		return new ResponseEntity<>("Non ci sono libri", HttpStatus.NOT_FOUND);
	}
	//@PostMapping("books")
	@PostMapping("/books")
	public ResponseEntity<?> createBook(@RequestBody Book newBook) {
		try {
			Book book = bookService.saveBook(newBook);
			return new ResponseEntity<>(book, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}


}


