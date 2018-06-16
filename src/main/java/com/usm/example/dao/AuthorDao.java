package com.usm.example.dao;

import com.usm.example.model.Author;

import java.util.List;

public interface AuthorDao {
    void create(Author author);
    Author findOne(Long id);
    Author findByFirstName(String firstName);
    List<Author> findAll();
    void update(Author author);
    void delete(Author author);
}
