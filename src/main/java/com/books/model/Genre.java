package com.books.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    private UUID id;
    
    @Column
    private String genre;

    public UUID getId() {
        return id;
    }
    public String getGenre() {
        return genre;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

}
