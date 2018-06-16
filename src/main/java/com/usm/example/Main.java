package com.usm.example;

import com.usm.example.config.SpringConfiguration;
import com.usm.example.dao.AuthorDao;
import com.usm.example.model.Author;
import com.usm.example.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        final AuthorDao authorDao = context.getBean(AuthorDao.class);

        // Initialize authors
        final Author joraPartizan = new Author("Jora", "Partizan");
        final Author valeraKardan = new Author("Valera", "Kardan");

        // Add books to first author
        final Set<Book> joraPartizanBooks = joraPartizan.getBooks();
        joraPartizanBooks.add(new Book("Jora's first book"));
        joraPartizanBooks.add(new Book("Jora's second book"));

        // Add books to second author
        final Set<Book> valeraKardanBooks = valeraKardan.getBooks();
        valeraKardanBooks.add(new Book("Valera's first book"));
        valeraKardanBooks.add(new Book("Valera's second book"));

        // Save authors and books(cascade) in db
        authorDao.create(joraPartizan);
        authorDao.create(valeraKardan);

        // Find author by primary key
        System.out.println("Author with id{1}: " + authorDao.findOne(1L));

        // Find all authors
        System.out.println("All authors: " + authorDao.findAll());

        // Update author
        joraPartizan.setFirstName("Alex");
        authorDao.update(joraPartizan);
        System.out.println("Updated author: " + authorDao.findByFirstName("Alex"));

        // Delete author
        authorDao.delete(valeraKardan);
        System.out.println("Deleted author: " + authorDao.findOne(2L));

        context.close();
    }

}
