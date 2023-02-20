package com.educc0r.rxjava.services;

import com.educc0r.rxjava.models.Author;
import io.reactivex.Maybe;
import io.reactivex.Single;

import java.util.List;

public interface AuthorService {

    Single<Author> addAuthor(Author author);

    Single<List<Author>> findAuthors();

    Maybe<Author> findAuthor(Integer id);

    Single<Author> updateAuthor(Integer id, Author author);

    Maybe<Author> deleteAuthor(Integer id);

}
