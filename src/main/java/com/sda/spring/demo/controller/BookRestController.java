package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AuthorService authorService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello world";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @CrossOrigin(value="http://localhost:8000")
    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> books() {
        return bookService.getBooks();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return book;
    }

    //category
    @RequestMapping(value = "/api/category", method = RequestMethod.GET)
    public List<Category> categories() {
        return categoryService.getCategories();
    }

    @CrossOrigin(value = "http://localhost:8000")
    @RequestMapping(value = "api/category", method = RequestMethod.POST)
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    //author
    @RequestMapping(value = "api/author", method = RequestMethod.GET)
    public List<Author> authors() {
        return authorService.getAuthors();
    }

    @CrossOrigin(value = "http://localhost:8000")
    @RequestMapping(value = "api/author", method = RequestMethod.POST)
    public ResponseEntity<Author> addAuthor(@Valid @RequestBody Author author) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(authorService.addAuthor(author));
    }

    @RequestMapping(value = "api/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> book(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
    }
    @RequestMapping(value = "api/category/{id}",method = RequestMethod.GET)
    public ResponseEntity<Category> category(@PathVariable Long id){
    return ResponseEntity.status(HttpStatus.OK)
        .body(categoryService.findById(id));
    }

    @RequestMapping(value="api/category/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category){
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(categoryService.updateCategory(id, category));
    }
    @RequestMapping(value="api/author/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author){
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(authorService.updateAuthor(id, author));
    }
    @RequestMapping(value="api/author/{id}",method = RequestMethod.GET)
    public ResponseEntity<Author> find(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(authorService.findById(id));
    }
}
