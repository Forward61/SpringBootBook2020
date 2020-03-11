package com.freedom.repository;

import com.freedom.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface QueryInterface {
//    @Query("select * from book u where u.bookname like %?1%")
//    public List<Book> searchQuery(@Param("bookname") String bookname);

    @Query(value = "select * from book u where u.bookname like %?1% or u.bookauthor like %?1%", nativeQuery = true)
    List<Book> queryBook(String bookname);
}
