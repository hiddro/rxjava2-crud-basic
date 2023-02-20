package com.educc0r.rxjava.repository;

import com.educc0r.rxjava.models.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositories extends GenericRepo<Book, Integer> {
}
