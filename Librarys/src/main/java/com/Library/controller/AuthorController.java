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
import org.springframework.web.bind.annotation.RestController;

import com.Library.entity.Author;

import com.Library.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;


    @GetMapping
    public ResponseEntity<Object> getAllAuthors() {
        List<Author> authors = service.findAll();
        if (!authors.isEmpty()) {
            return new ResponseEntity<>(authors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Non ci sono autori", HttpStatus.NOT_FOUND);
        }
    }

    
    @PostMapping("/creaAutore")
    public ResponseEntity<?> createAuthor(@RequestBody Author author) {
        try {
            Author salvaAutore = service.save(author);
            return new ResponseEntity<>(salvaAutore, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAuthor/{id}")
    public ResponseEntity<Object> getAuthorById(@PathVariable int id) {
        Optional<Author> autore = service.findById(id);
        if (autore.isPresent()) {
            return ResponseEntity.ok(autore.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autore non trovato");
        }
    }
    @DeleteMapping("/author/{id}")
    public ResponseEntity<String>deleteBook(@PathVariable Integer id){
    	service.deleteById(id);
    	return new ResponseEntity<>("Autore eliminato con successo", HttpStatus.OK);
    
    }
    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable Integer id, @RequestBody Author autor ){
    	 Author aggiornamento= service.updateAutoreById(id,autor);
		 return new ResponseEntity<>(aggiornamento, HttpStatus.OK);
    }

    
}
