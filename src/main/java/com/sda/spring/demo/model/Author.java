package com.sda.spring.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @NotNull
    @Size(min=2,max=10,message = "od 2 do 10 znakow")
    public String name;
    @NotNull
    @Size(min=2,max=10,message = "od 2 do 10 znakow")
    public String lastname;

    @ManyToMany(mappedBy = "authors")
    Set<Book> books;

    public Author() {
    }

    public Author(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setId(long l) {
        this.id=l;
    }
}
