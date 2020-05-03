package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book {
    @Column(name = "title")
    private String title;

    @Id
    @Column(name="isbn")
    private String isbn;

    @Column(name="author")
    private String author;

}
