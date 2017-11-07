package com.motuma.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.books.models.Book;
import com.motuma.books.repositories.BookRepository;


@Service
public class BookService {
	 private BookRepository bookRepository;
	 public BookService(BookRepository bookRepository){
		 this.bookRepository = bookRepository;
	 }
	 public List<Book> allBooks(){
		 return bookRepository.findAll();
	 }
	 public void addBook(Book book){
		 bookRepository.save(book);
	 }
	 
	 public void destroyBook(Long id) {
		 bookRepository.delete(id);
	 }
	 
	 public Book findById(long id){
			return (Book)  bookRepository.findOne(id);
		}
}
