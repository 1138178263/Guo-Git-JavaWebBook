package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"国哥很帅","19125",new BigDecimal(9999),1100000,0,null));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"大家都这么说","191125",new BigDecimal(9999),10000,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for(Book queryBook:bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }
}