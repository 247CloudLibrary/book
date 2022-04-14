package com.cloudlibrary.books.infrastructure.persistence.mysql.repository;

import com.cloudlibrary.books.application.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository {


    List<Book> findBookAll();

    Optional<Book> findBookById(Long bookId);

}
