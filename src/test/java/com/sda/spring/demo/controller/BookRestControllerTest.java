/*
package com.sda.spring.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;
    @MockBean
    private BookService bookService;
    @MockBean
    private CategoryRepository categoryRepository;
    @MockBean
    private AuthorRepository authorRepository;
    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private AuthorService authorService;


    ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("given categories when get categories then return json array")
    @Test
    public void test() throws Exception {
        Category category = new Category("Fantastyka");
        Category category1 = new Category("Dokument");
        Category category2 = new Category("Si-Fi");

        List<Category> categories = Arrays.asList(category, category1, category2);
        BDDMockito.given(categoryService.getCategories()).willReturn(categories);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/book/category")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
        verify(categoryService, VerificationModeFactory.times(2))
                .getCategories();
    }

    @DisplayName("should update Category")
    @Test
    public void test1() throws Exception {
        Category category = new Category("Dokument");
        category.setId(100L);

        given(categoryService.findById(100L)).willReturn(category);
        ResultActions resultActions = mockMvc.perform(put("/api/category/100")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(category)));
        resultActions.andExpect(status().isNoContent());

        Category category1 = categoryService.findById(100L);
        assertThat(category1).isNotNull();
        assertThat(category1.getName()).isEqualTo("Dokument");
    }

    @DisplayName("should create new category when try to update with not found id")
    @Test
    public void test2() throws Exception {
        given(categoryService.findById(anyLong())).willReturn(null);
        Category category = new Category("Fantastyka");

        ResultActions resultActions = mockMvc.perform(put("/api/category/10")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(category)));

        resultActions.andExpect(status().isNoContent());
    }

    @DisplayName("get with authors return 201")
    @Test
    public void test3() throws Exception {

        Author author1 = new Author();
        Author author2 = new Author();
        Author author3 = new Author();
        List<Author> authors = Arrays.asList(author1, author2, author3);
        given(authorService.getAuthors()).willReturn(authors);
        ResultActions resultActions = mockMvc.perform(get("/api/author")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(authors)));

        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$", hasSize(3)));
    }

    @DisplayName("should return 201 when post author")
    @Test
    public void test4() throws Exception {
        Author author=new Author("Goobar","Foobar");
        Author author1=new Author("Hoobar","Updated");
        author.setId(34L);
        given(authorService.findById(34L)).willReturn(author);

        ResultActions resultActions = mockMvc.perform(put("/api/author/34")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(author1)));
        resultActions.andExpect(status().isNoContent());
       Author up=authorService.findById(34L);
       assertThat(up).isNotNull();
       assertThat(up.getName()).isEqualTo("Hoobar");
    }

}*/
