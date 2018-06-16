package com.usm.example.dao.impl;

import com.usm.example.dao.AuthorDao;
import com.usm.example.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public AuthorDaoImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(final Author author) {
        session().save(author);
    }

    @Override
    public Author findOne(final Long id) {
        return session().get(Author.class, id);
    }

    @Override
    public List<Author> findAll() {
        return session()
                .createQuery("select a from Author a", Author.class)
                .list();
    }

    @Override
    public void update(final Author author) {
        session().update(author);
    }

    @Override
    public void delete(final Author author) {
        session().delete(author);
    }

    @Override
    public Author findByFirstName(final String firstName) {
        return session()
                .createQuery("select a from Author a where a.firstName=:firstName", Author.class)
                .setParameter("firstName", firstName)
                .getSingleResult();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }
}
