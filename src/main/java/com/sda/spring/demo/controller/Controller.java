package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AuthorRepository authorRepository;



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
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    //category
    @RequestMapping(value = "/api/category", method = RequestMethod.GET)
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @RequestMapping(value = "api/category", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        return category;
    }
    //author
    @RequestMapping(value="api/author",method = RequestMethod.GET)
    public List<Author> authors(){
       return authorRepository.findAll();
    }
    @RequestMapping(value = "api/author",method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author){
        authorRepository.save(author);
    return author;
    }

}
