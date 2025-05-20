package com.Library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Library.entity.Book;
import com.Library.entity.Book.genre;
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
	
	@PostMapping("/books")
	public ResponseEntity<?> createBook(@RequestBody Book newBook) {
		try {
				
			Book book = bookService.saveBook(newBook);
			return new ResponseEntity<>(book, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/findBook/{id}")
	public ResponseEntity<Object> getBooksById(@PathVariable int id) {
	   
		Optional<Book> book = bookService.findBookById(id);
	    if (book.isPresent()) {
	        return new ResponseEntity<>(book.get(), HttpStatus.OK);
	    }
	    return new ResponseEntity<>("Non ci sono libri", HttpStatus.NOT_FOUND);
	}

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String>deleteBook(@PathVariable Integer id){
    	bookService.deleteBookById(id);
    	return new ResponseEntity<>("Libro eliminato con successo", HttpStatus.OK);
    
    }
    @GetMapping("/books/genre/{genre}")
    public ResponseEntity<Object> getBookByGenre(@PathVariable String genre) {
        List<Book> books = bookService.findBooksByGenre(genre);
        if (books != null && !books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nessun libro trovato per il genere: " + genre, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("find/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book ){
    	 Book aggiornamento= bookService.updateBookById(id,book);
		 return new ResponseEntity<>(aggiornamento, HttpStatus.OK);
    }
    @GetMapping("/genres")
    public List<String> getAllGenres() {
        return bookService.findAllGenres();
    }
    
    // prova con enum
    @GetMapping("/enum")  
    public List<genre> allGenreEnum(){
    	return bookService.allGenreEnum();
    }

}


