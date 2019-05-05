/*
package com.sda.spring.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @TestConfiguration
    public static class CategoryServiceTestConfig {
        @Bean
        public CategoryService categoryService() {
            return new CategoryService();
        }
    }


    @MockBean
    private CategoryService categoryService;


    @Before
    public void setUp() {
        Category category = new Category("Dokument");
        Mockito
                .when(categoryService.findByName(category.getName()))
                .thenReturn(category);
        //mockMvc.perform(put(""))
    }

    @Test
    public void whenValidName_thenCategoryShouldBeFound() {

        String name = "Dokument";
        Category found = categoryService.findByName(name);
        assertThat(found.getName()).isEqualTo(name);
    }


}*/
