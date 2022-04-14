package com.cloudlibrary.books.application.service;

import com.cloudlibrary.books.application.domain.Book;
import com.cloudlibrary.books.exception.CloudLibraryException;
import com.cloudlibrary.books.exception.MessageType;
import com.cloudlibrary.books.infrastructure.persistence.mysql.entity.BookEntity;
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
    public void createBook(BookCreateCommand command) {
       Book book =  Book.builder()
                .rid(command.getRid())
                .isbn(command.getIsbn())
                .title(command.getTitle())
                .thumbNailImage(command.getThumbNailImage())
                .coverImage(command.getCoverImage())
                .author(command.getAuthor())
                .translator(command.getTranslator())
                .contents(command.getContents())
                .publisher(command.getPublisher())
                .publishDate(command.getPublishDate())
                .bookType(command.getBookType())
                .genre(command.getGenre())
                .barcode(command.getBarcode())
                .rfid(command.getRfid())
                .bookStatus(command.getBookStatus())
                .categoryId(command.getCategoryId())
                .libraryName(command.getLibraryName())
                .build();

        bookEntityRepository.saveBook(new BookEntity(book));
    }

    @Override
    public Long updateBook(BookUpdateCommand command) {

        Optional<Book> findBook = bookEntityRepository.findBookById(command.getId());

        if (findBook.isEmpty()) {
            throw new CloudLibraryException(MessageType.NOT_FOUND);
        }

        Book book =  Book.builder()
                .id(command.getId())
                .rid(command.getRid())
                .isbn(command.getIsbn())
                .title(command.getTitle())
                .thumbNailImage(command.getThumbNailImage())
                .coverImage(command.getCoverImage())
                .author(command.getAuthor())
                .translator(command.getTranslator())
                .contents(command.getContents())
                .publisher(command.getPublisher())
                .publishDate(command.getPublishDate())
                .bookType(command.getBookType())
                .genre(command.getGenre())
                .barcode(command.getBarcode())
                .rfid(command.getRfid())
                .bookStatus(command.getBookStatus())
                .categoryId(command.getCategoryId())
                .libraryName(command.getLibraryName())
                .build();

        return bookEntityRepository.updateBook(new BookEntity(book));
    }


    @Override
    public void deleteBook(BookDeleteCommand command) {

        Book book = bookEntityRepository.findBookById(command.getId())
                .orElseThrow(() -> new CloudLibraryException(MessageType.NOT_FOUND));

        bookEntityRepository.deleteBook(book.getId());
    }
}
