package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    @Query("SELECT b FROM Book b")
    List<Book> getAllBooks();

    Book getBookByTitle(String title);

    Book getBookByIsbn(String isbn);
}
