package com.cloudlibrary.books.application.service;

import com.cloudlibrary.books.application.domain.Book;
import com.cloudlibrary.books.infrastructure.persistence.mysql.entity.BookEntity;
import com.cloudlibrary.books.infrastructure.persistence.mysql.repository.BookEntityRepository;
import com.cloudlibrary.books.infrastructure.query.http.feign.client.CompositeRequestClient;
import com.cloudlibrary.books.infrastructure.query.http.feign.service.FeignCompositeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class BookService implements BookReadUseCase,BookOperationUseCase {

    private final BookEntityRepository bookEntityRepository;


    public BookService(BookEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;

    }



    @Override
    @Transactional
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
                .category(command.getCategory())
                .libraryName(command.getLibraryName())
                .build();


        BookEntity save = bookEntityRepository.save(new BookEntity(book));

    }

    @Override
    public Long updateBook(BookUpdateCommand command) {
        return null;
    }

    @Override
    public void deleteBook(BookDeleteCommand command) {

    }

    @Override
    public List<FindBookResult> getBookAllList() {
        return null;
    }

    @Override
    public FindBookResult getBook(BookFindQuery query) {
        return null;
    }
}
