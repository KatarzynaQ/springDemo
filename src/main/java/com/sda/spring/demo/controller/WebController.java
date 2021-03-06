package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.model.User;
import com.sda.spring.demo.repository.UserRepository;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
import com.sda.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookService.getBooks());
        modelAndView.setViewName("index");
        return modelAndView;

    }

    @GetMapping(value = "/category")
    public ModelAndView category() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("category");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @GetMapping(value = "/author")
    public ModelAndView autor() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("author", new Author());
        modelAndView.setViewName("author");
        return modelAndView;
    }


    @PostMapping(value = "/category")
    public void addCategory(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
    }

    @PostMapping(value = "/author")
    public void addAuthor(@ModelAttribute("author") Author author) {
        authorService.addAuthor(author);
    }


    @PostMapping(value = "/register")
    public ModelAndView registerUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView=new ModelAndView();
        userService.addUser(user);
        modelAndView.addObject("successMessage","User has been registered successfully");
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("user",new User());
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @GetMapping(value = "/login")
    public  ModelAndView loginGet(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }

}
