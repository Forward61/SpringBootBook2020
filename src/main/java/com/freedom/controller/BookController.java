package com.freedom.controller;


import com.freedom.entity.Book;
import com.freedom.repository.BookRepository;
import com.freedom.repository.QueryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController  implements QueryInterface {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/findAll")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return bookRepository.findAll(pageRequest);
    }


    @PostMapping("/save")
    public String save(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }


    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id) {
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }


    @DeleteMapping("/delete/{bid}")
    public void delete(@PathVariable Integer bid) {

        bookRepository.deleteById(bid);
    }

    @PostMapping("/search")
    @Query("select * from book u where u.bookname like %?1%")
    public List<Book> search(@RequestBody Book book) {
        Example<Book> example = Example.of(book);
        List<Book> resultList = bookRepository.findAll(example);

        return resultList;
    }



    @Override
    public List<Book> queryBook(String bookname) {
        return null;
    }

//    @Override
//    public List<Book> searchQuery(Book book) {
//        return null;
//    }
}
