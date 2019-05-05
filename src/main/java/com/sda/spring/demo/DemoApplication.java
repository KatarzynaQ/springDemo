package com.sda.spring.demo;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;

import com.sda.spring.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication  {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

  //  @Override
    //public void run(String... args) throws Exception {
       // Person person = applicationContext.getBean(Person.class);
        //person.setName("Jan");
//        Set<Author> authors=new HashSet<>();
//        Book book = new Book("Programowanie");
//        authors.add(new Author("Jan","Kowalski"));
//        book.setAuthors(authors);
//
//        book.setCategory(new Category("comedy"));
//        bookRepository.save(book);

   // }
}
