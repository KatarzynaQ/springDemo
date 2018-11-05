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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class Controller {

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

    @RequestMapping(value = "api/category", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return category;
    }

    //author
    @RequestMapping(value = "api/author", method = RequestMethod.GET)
    public List<Author> authors() {
        return authorService.getAuthors();
    }

    @RequestMapping(value = "api/author", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return author;
    }

    @RequestMapping(value = "api/books/{id}", method = RequestMethod.GET)
    public Book book(@PathVariable Long id) {
        return bookService.findById(id);
    }
    @RequestMapping(value = "api/category/{id}",method = RequestMethod.POST)
    public Category category(@PathVariable Long id){
    return categoryService.findById(id);
    }
    @RequestMapping(value="api/author/{id}",method = RequestMethod.POST)
    public Author find(@PathVariable Long id){
        return authorService.findById(id);
    }
}
