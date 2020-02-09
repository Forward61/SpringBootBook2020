package com.freedom.repository;

import com.freedom.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created by freedom on 2020/2/7.
 */

@SpringBootTest
class BookRepositoryTest {


    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        PageRequest pageRequest = PageRequest.of('0', '3');

        Page<Book> page = bookRepository.findAll(pageRequest);
        int i =0;
    }

    @Test
    void save(){
        Book book = new Book();
        book.setBookname("Sprigffffff");
        book.setBookauthor("sssdsauthor");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void findById(){
       Book book =  bookRepository.findById(1).get();
        System.out.println(book);
    }

    @Test
    void update(){
        Book book = new Book();
        book.setBid(13);
        book.setBookname("testetttttt");
        Book book1 =   bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void delete(){

        bookRepository.deleteById(2);

    }
}