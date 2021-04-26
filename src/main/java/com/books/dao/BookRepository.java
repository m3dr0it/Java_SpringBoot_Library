package com.books.dao;

import java.util.List;
import java.util.UUID;

import com.books.model.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, UUID>{
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);}