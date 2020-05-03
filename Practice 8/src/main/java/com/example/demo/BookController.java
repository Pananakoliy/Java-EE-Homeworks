package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public List<Book> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return bookService.getAllBooks();
    }

    @PostMapping("/search")
    public List<Book> search(@RequestBody Book book){
        return bookService.search(book);
    }
}
