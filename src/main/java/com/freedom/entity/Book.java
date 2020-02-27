package com.freedom.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by freedom on 2020/2/6.
 */
@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;
    private String bookname;
    private String bookauthor;
}
