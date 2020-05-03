package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String title;
    private String isbn;
    private String author;


    @Override
    public String toString() {
        return "Book{" +
                "name='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
