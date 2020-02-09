package com.freedom.repository;

import com.freedom.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by freedom on 2020/2/7.
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
}
