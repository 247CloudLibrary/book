package com.cloudlibrary.books.infrastructure.persistence.mysql.repository;

import com.cloudlibrary.books.application.domain.Book;
import com.cloudlibrary.books.infrastructure.persistence.mysql.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookEntityRepository {

    List<Book> findBookAll();

    Optional<Book> findBookById(Long bookId);

    void saveBook(BookEntity bookEntity);

    Long updateBook(BookEntity bookEntity);

}
