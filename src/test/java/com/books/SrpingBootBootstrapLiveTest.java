package com.books;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.hamcrest.Matchers.*;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.books.dao.BookRepository;
import com.books.model.Book;

public class SrpingBootBootstrapLiveTest {
    private static final String API_ROOT = "http://localhost:8081/api/books";

    private Book createRandomBook(){
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle(RandomStringUtils.randomAlphabetic(10));
        book.setAuthor(RandomStringUtils.randomAlphabetic(10));
        return book;
    }

    private String createBookAsUri(Book book){
        Response response = RestAssured.given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(book)
        .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

    @Test
    public void whenGetAllBooks_thenOk(){
        Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetBooksByTitle_thenOk(){
        Book book = createRandomBook();
        createBookAsUri(book);
        Response response = RestAssured.get(API_ROOT+"/title/"+book.getTitle());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class).size() > 0);
    }

    @Test
    public void whenUpdateBook_thenOk(){       
        Book book = createRandomBook();
        createBookAsUri(book);

        book.setTitle("Bumi Cinta");
        book.setAuthor("Habiburrahman El Shirazy");

        System.out.println(API_ROOT+"/"+book.getId());

        Response response = given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(book)
        .put(API_ROOT+"/"+book.getId());
        
        assertEquals(HttpStatus.OK.value(),  response.getStatusCode());

        // get(API_ROOT+"/title/"+book.getTitle()).then().statusCode(HttpStatus.OK.value()).assertThat()
        // .body("author",equalTo(book.getAuthor()));
    }

    @Test
    public void whenUpdateCreatedBook_thenUpdated() {
        Book book = createRandomBook();
        String location = createBookAsUri(book);

        System.out.println(location);
        book.setAuthor("newAuthor");
        Response response = RestAssured.given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(book)
        .put(location);
        
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("newAuthor", response.jsonPath()
        .get("author"));
    }

    @Test
    public void whenDelete_thenOk(){
        Book book = createRandomBook();
        createBookAsUri(book);
        String deleteUri = API_ROOT+"/"+book.getId();

        Response response = given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .delete(deleteUri);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
}