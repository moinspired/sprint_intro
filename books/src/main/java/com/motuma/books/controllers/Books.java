package com.motuma.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.motuma.books.models.Book;
import com.motuma.books.services.BookService;

@Controller
public class Books {
	private final BookService bookService;
	
	public Books(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/")
    public String books() {
        return "books.jsp";
    }
 
    @RequestMapping("/books/{index}")
    public String findBookByIndex(@PathVariable("index") Long index, Model model) {
        model.addAttribute("book", bookService.findById(index));
        return "book";
    }
}
