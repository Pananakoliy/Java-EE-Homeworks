package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public void addBook(Book book){
        bookRepository.save(book);
    }

    @Transactional
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

    @Transactional
    public List<Book> search(Book book){return bookRepository.getBooksByTitleContainingAndIsbnContainingAndAuthorContaining(book.getTitle(),book.getIsbn(),book.getAuthor());}
}
