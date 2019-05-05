/*
package com.sda.spring.demo.service;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
public class BookServiceTest {

    @TestConfiguration
    public static class BookConfigurationTest{

        @Bean
        BookService bookService(){
            return  new BookService();
        }
    }
@Autowired
BookService bookService;

@MockBean
BookRepository bookRepository;

@Before
public void setUp(){
    Book book=new Book("Java");
    Mockito
            .when(bookRepository.findByTittle("Java"))
            .thenReturn(book);
}

    @Test
    public void shouldFindBookByTittle(){

        Book found=bookService.findByTittle("Java");
        assertThat(found.getTittle()).isEqualTo("Java");
    }
}*/
