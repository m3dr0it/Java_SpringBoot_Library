package com.books.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Column(nullable = false,unique = true)
    private String title;

    @Column(nullable = true,unique = false)
    private String author;

    @Id
    private UUID id;

    public String getAuthor() {
        return author;
    }
    public UUID getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setId(UUID id) {
        this.id = id;
    }
}
