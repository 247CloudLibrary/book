package com.cloudlibrary.books.infrastructure.persistence.mysql.repository;

import com.cloudlibrary.books.application.domain.Book;
import com.cloudlibrary.books.application.domain.BookStatus;
import com.cloudlibrary.books.infrastructure.persistence.mysql.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookEntityRepository extends JpaRepository<BookEntity,Long> {

    /**
     *BookStatus가 DISCARD인거 제외하고 가져오기
     */
    List<BookEntity> findAllBookByBookStatusNot(BookStatus status);

   Optional<BookEntity> findByIdAndBookStatusNot(Long bookId, BookStatus status);
}
