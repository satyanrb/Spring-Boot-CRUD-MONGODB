package com.javatachie.spring.mongo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatachie.spring.mongo.api.model.Book;
import com.javatachie.spring.mongo.api.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepo;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		bookRepo.save(book);
		return "Book with Id: "+book.getId()+" saved successfully";
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooksFromDB(){
		return bookRepo.findAll();
	}
	
	@GetMapping("/getBookById/{id}")
	public Optional<Book> getBookById(@PathVariable int id) {
		return bookRepo.findById(id);
	}

	@DeleteMapping("removebook/{id}")
	public String removeBookById(@PathVariable int id) {
		bookRepo.deleteById(id);
		return "Book with Id: "+id+" is removed successfully from db";
	}
}
