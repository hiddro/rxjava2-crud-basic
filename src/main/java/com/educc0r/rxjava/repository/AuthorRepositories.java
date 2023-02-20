package com.educc0r.rxjava.repository;

import com.educc0r.rxjava.models.Author;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepositories extends GenericRepo<Author, Integer> {
    Optional<Author> findAuthorByNameEqualsIgnoreCase(String name);
}
