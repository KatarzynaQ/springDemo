package com.sda.spring.demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Author> authors;

    @ManyToOne(cascade = CascadeType.PERSIST)
    //@JoinColumn("books")
    Category category;

    public Book() {
    }

    public Book(String tittle) {
        this.tittle = tittle;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Set<Author> getAuthor() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
