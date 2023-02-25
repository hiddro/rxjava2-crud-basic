package com.educc0r.rxjava.rest;

import com.educc0r.rxjava.models.Author;
import com.educc0r.rxjava.services.AuthorService;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/authors")
public class Authorcontroller {

    @Autowired
    private AuthorService authorService;

    /*METODO GET BY ID*/
    @GetMapping("/{id}")
    public Maybe<ResponseEntity<Author>> getAuthor(@PathVariable Integer id) {
        return authorService.findAuthor(id)
                .subscribeOn(Schedulers.io())
                .map(s -> ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(s));
    }

    /*METODO GET ALL*/
    @GetMapping()
    public Single<ResponseEntity<List<Author>>> getAuthors(){
        return authorService.findAuthors()
                .subscribeOn(Schedulers.io())
                .map(s -> ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(s));
    }

    /*METODO POST*/
    @PostMapping()
    public Single<ResponseEntity<Author>> addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author)
                .subscribeOn(Schedulers.io())
                .map(s -> ResponseEntity
                        .created(URI.create("/api/authors/" + s.getIdAuthor()))
                        .body(s));
    }

    /*METODO PUT*/
    @PutMapping("/{id}")
    public Single<ResponseEntity<Author>> modAuthor(@PathVariable Integer id, @RequestBody Author author){
        return authorService.updateAuthor(id, author)
                .subscribeOn(Schedulers.io())
                .map(s -> ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(s));
    }

    /*METODO DELETE*/
    @DeleteMapping("/{id}")
    public Maybe<ResponseEntity<Author>> delAuthor(@PathVariable Integer id){
        return authorService.deleteAuthor(id)
                .subscribeOn(Schedulers.io())
                .map(s -> ResponseEntity
                        .ok()
                        .body(s));
    }

}
