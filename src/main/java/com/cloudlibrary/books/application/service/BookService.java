package com.cloudlibrary.books.application.service;

import com.cloudlibrary.books.application.domain.Book;
import com.cloudlibrary.books.exception.CloudLibraryException;
import com.cloudlibrary.books.exception.MessageType;
import com.cloudlibrary.books.infrastructure.persistence.mysql.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class BookService implements BookReadUseCase{

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<FindBookResult> getBookAllList() {

        return bookRepository.findBookAll().stream().map(FindBookResult::findByBook).collect(Collectors.toList());
    }

    @Override
    public FindBookResult getBook(BookFindQuery query) {
        Optional<Book> result = bookRepository.findBookById(query.getBookId());

        if (result.isEmpty()) {
            throw new CloudLibraryException(MessageType.NOT_FOUND);
        }

        return FindBookResult.findByBook(result.get());
    }
}
