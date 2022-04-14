package com.cloudlibrary.books.application.service;

import com.cloudlibrary.books.application.domain.Book;
import com.cloudlibrary.books.exception.CloudLibraryException;
import com.cloudlibrary.books.exception.MessageType;
import com.cloudlibrary.books.infrastructure.persistence.mysql.repository.BookEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class BookService implements BookReadUseCase,BookOperationUseCase{

    private final BookEntityRepository bookEntityRepository;

    public BookService(BookEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;
    }


    @Override
    public List<FindBookResult> getBookAllList() {

        return bookEntityRepository.findBookAll().stream().map(FindBookResult::findByBook).collect(Collectors.toList());
    }

    @Override
    public FindBookResult getBook(BookFindQuery query) {
        Optional<Book> result = bookEntityRepository.findBookById(query.getBookId());

        if (result.isEmpty()) {
            throw new CloudLibraryException(MessageType.NOT_FOUND);
        }

        return FindBookResult.findByBook(result.get());
    }

    @Override
    public void deleteBook(BookDeleteCommand command) {

        Book book = bookEntityRepository.findBookById(command.getId())
                .orElseThrow(() -> new CloudLibraryException(MessageType.NOT_FOUND));

        bookEntityRepository.deleteBook(book.getId());
    }
}
