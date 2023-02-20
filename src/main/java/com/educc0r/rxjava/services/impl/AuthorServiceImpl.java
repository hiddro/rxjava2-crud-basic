package com.educc0r.rxjava.services.impl;

import com.educc0r.rxjava.models.Author;
import com.educc0r.rxjava.repository.AuthorRepositories;
import com.educc0r.rxjava.services.AuthorService;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepositories authorRepositories;

    @Override
    public Single<Author> addAuthor(Author author) {
        return Single.create(singleSubscriber -> {
            if(!authorRepositories.findAuthorByNameEqualsIgnoreCase(author.getName()).isPresent()) {
                singleSubscriber.onSuccess(authorRepositories.save(author));
            }else{
                singleSubscriber.onError(new Throwable("Usuario ya Existe!"));
            }
        });
    }

    @Override
    public Single<List<Author>> findAuthors() {
        return Single.create(singleSubscriber -> {
           singleSubscriber.onSuccess(authorRepositories.findAll());
        });
    }

    @Override
    public Maybe<Author> findAuthor(Integer id) {
        return Maybe.create(maybeSubscriber -> {
            maybeSubscriber.onSuccess(authorRepositories.findById(id).get());
        });
    }

    @Override
    public Single<Author> updateAuthor(Integer id, Author author) {
        return Single.create(singleSubscriber -> {
            Optional<Author> authorReg = authorRepositories.findById(id);
            if(authorReg.isPresent()) {
                authorReg.get().setName(author.getName());
                singleSubscriber.onSuccess(authorRepositories.save(authorReg.get()));
            }else{
                singleSubscriber.onError(new Throwable("Usuario No Existe!"));
            }
        });
    }

    @Override
    public Maybe<Author> deleteAuthor(Integer id) {
        return Maybe.create(maybeSubscriber -> {
            Optional<Author> authorReg = authorRepositories.findById(id);
            if(authorReg.isPresent()) {
                authorRepositories.deleteById(id);
                maybeSubscriber.onSuccess(authorReg.get());
            }else{
                maybeSubscriber.onError(new Throwable("Usuario No Existe!"));
            }
        });
    }
}
