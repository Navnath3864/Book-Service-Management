package com.api.book.bootrestbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entity.Book;

import com.api.book.bootrestbook.service.BookServicesImpl;

@RestController
// @Controller -> @responseBody is required in class
public class BookController {

	@Autowired
	private BookServicesImpl bookServicesImpl;

	// @GetMapping("/books")
//	@RequestMapping(value = "/books", method = RequestMethod.GET)
//	@ResponseBody

	/*
	 * public Book getBook() { System.out.println("done!!!!!!!!!!!!"); Book book =
	 * new Book(); book.setId(1); book.setBooktitle("abc"); book.setAuthor("xyz");
	 * return book; }
	 */

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> list = bookServicesImpl.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	@GetMapping("/books/{id}")

	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = bookServicesImpl.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));

	}

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b=null;
		try {
			b=this.bookServicesImpl.addBook(book);
			System.out.println(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// delete book
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Book> deleteBook(@PathVariable("bookId") int bookId) {
		
		try {
			this.bookServicesImpl.deleteBook(bookId);
			System.out.println("Book deletion successful !!!!!!!!!");
			return ResponseEntity.status(HttpStatus.CREATED).build();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
