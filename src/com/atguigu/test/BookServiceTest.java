package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"你好","19125",new BigDecimal(9999),1100000,0,null));
    }

    @Test
    public void deleteBookById() {

    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"不好","191125",new BigDecimal(9999),10000,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for(Book queryBook:bookService.queryBooks()){
            System.out.println(queryBook);
        }
    }
}