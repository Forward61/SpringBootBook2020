package com.freedom.repository;

import com.freedom.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by freedom on 2020/2/7.
 */

@SpringBootTest
class BookRepositoryTest {


    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll() {
        PageRequest pageRequest = PageRequest.of('0', '3');

        Page<Book> page = bookRepository.findAll(pageRequest);
        int i = 0;
    }

    @Test
    void save() {
        Book book = new Book();
        book.setBookname("Sprigffffff");
        book.setBookauthor("sssdsauthor");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void findById() {
        Book book = bookRepository.findById(2).get();
        System.out.println(book);
    }

    @Test
    void update() {
        Book book = new Book();
        book.setBid(13);
        book.setBookname("testetttttt");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void delete() {

        bookRepository.deleteById(2);

    }

//    @Test
//    public void search() {
//
//        Book bookExample = new Book();
//        bookExample.setBookname("mysql");
//        Example<Book> example = Example.of(bookExample);
//        List<Book> resultList = bookRepository.findAll(example);
//        System.out.println(resultList);
//    }

    @Test
    public void searchQuery() {

        List<Book> resultList = bookRepository.queryBook("pring");
        System.out.println(resultList);
        System.out.println("ss");
    }
}