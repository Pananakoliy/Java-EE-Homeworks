package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @Autowired
    BookService bookService;

    @RequestMapping({"/",""})
    public String index(Model model){
        model.addAttribute("book", new Book());
        return "index";
    }

    @RequestMapping(value = "/add_book",method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute Book book){
        bookService.addBook(book);
        return "redirect:/book_list";
    }

    @RequestMapping(value = "/book_list", method = RequestMethod.GET)
    public String bookList(Model model){
        model.addAttribute("books",bookService.getAllBooks());
        return "books";
    }

    @RequestMapping(value = "/search_by_title", method = RequestMethod.GET)
    public String searchByTitle(@ModelAttribute Book book, Model model){
        model.addAttribute("books",bookService.getBookByTitle(book.getTitle()));
        return "books";
    }

    @RequestMapping(value = "/search_by_isbn", method = RequestMethod.GET)
    public String searchByIsbn(@ModelAttribute Book book, Model model){
        model.addAttribute("books",bookService.getBookByTitle(book.getIsbn()));
        return "books";
    }
}
