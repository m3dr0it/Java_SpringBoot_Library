package com.books.dao;

import java.util.List;
import java.util.UUID;

import com.books.model.Book;

public class BookDataAccessService implements BookInterface{

    @Override
    public List<Book> listBook() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int findBook(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int addBook(String name, String author) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateBook(UUID id, String name, String author) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteBook(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
