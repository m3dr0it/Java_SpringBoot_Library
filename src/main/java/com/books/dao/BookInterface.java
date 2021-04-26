package com.books.dao;

import java.util.List;
import java.util.UUID;

import com.books.model.Book;

public interface BookInterface {
    int findBook(UUID id);
    List<Book> listBook();
    int addBook(String name,String author);
    int updateBook(UUID id, String name, String author);
    int deleteBook(UUID id);
}