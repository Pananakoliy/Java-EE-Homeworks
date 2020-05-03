package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    List<Book> bookList = new ArrayList<>();
    @RequestMapping({"/",""})
    public String index(Model model){
        model.addAttribute("book", new Book());
        return "index";
    }

    @RequestMapping(value = "/add_book",method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute Book book){
        bookList.add(book);
        return "redirect:/book_list";
    }

    @RequestMapping(value = "/book_list", method = RequestMethod.GET)
    public String bookList(Model model){
        model.addAttribute("books",bookList);
        return "books";
    }
}
