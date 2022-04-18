package com.cloudlibrary.books.infrastructure.persistence.mysql.repository;

import com.cloudlibrary.books.application.service.BookReadUseCase;
import com.cloudlibrary.books.infrastructure.persistence.mysql.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookEntityRepository extends JpaRepository<BookEntity,Long> {

}
