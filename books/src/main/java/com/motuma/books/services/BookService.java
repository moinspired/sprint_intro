package com.motuma.books.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.books.models.Book;

@Service
public class BookService {
	  List<Book> books = new ArrayList(Arrays.asList(
			   new Book("Est of Eden", "life in a book", "English", 400),
			   new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
	           new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)));
	  
	  public List<Book> allBooks(){
		  return books;
	  }
	  
	  public Book findBookByIndex(int index) {
		  if(index < books.size()) {
			  return books.get(index);
		  }
		  else {
			  return null;
		  }
	  }
	  public void addBook(Book book) {
		  books.add(book);
	  }
	  
	  public void updateBook(int id, Book book) {
		  if (id < books.size()) {
			  books.set(id,  book);
		  }
	  }
	  public void destroyBook(int id) {
	        if (id < books.size()){
	            books.remove(id);
	        }
	    }
}
