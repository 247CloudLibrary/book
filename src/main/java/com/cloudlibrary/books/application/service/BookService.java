package com.cloudlibrary.books.application.service;

import com.cloudlibrary.books.application.domain.Book;
import com.cloudlibrary.books.application.domain.BookStatus;
import com.cloudlibrary.books.exception.CloudLibraryException;
import com.cloudlibrary.books.exception.MessageType;
import com.cloudlibrary.books.infrastructure.persistence.mysql.entity.BookEntity;
import com.cloudlibrary.books.infrastructure.persistence.mysql.repository.BookEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookService implements BookReadUseCase,BookOperationUseCase {

    private final BookEntityRepository bookEntityRepository;



    public BookService(BookEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;

    }



    @Override
    @Transactional
    public OperationBookResult createBook(BookCreateCommand command) {

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
                .libraryId(command.getLibraryId())
                .libraryName(command.getLibraryName())
                .build();

        BookEntity saveBook = bookEntityRepository.save(new BookEntity(book));



      return OperationBookResult.requestBook(saveBook.toBook());

    }

    /**
     * findBookEntity.update => 도서 수정
     *
     * @return
     */
    @Override
    @Transactional
    public  OperationBookResult updateBook(BookUpdateCommand command) {

        BookEntity findBookEntity = bookEntityRepository.findByIdAndLibraryId(command.getId(),command.getLibraryId()).stream().findAny()
                .orElseThrow(() -> new CloudLibraryException(MessageType.NOT_FOUND));

        Book updateBook =  Book.builder()
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
                .category(command.getCategory())
                .libraryId(command.getLibraryId())
                .libraryName(command.getLibraryName())
                .build();

       findBookEntity.update(updateBook);

        return OperationBookResult.requestBook(findBookEntity.toBook());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FindBookResult> getBookAllList() {

        List<Book> findAllBook = bookEntityRepository.findAllBookByBookStatusNot(BookStatus.DISCARD)
                                    .stream().map(BookEntity::toBook)
                                    .collect(Collectors.toList());

        return findAllBook.stream().map(FindBookResult::findByBook).collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public FindBookResult getBook(BookFindQuery query) {
        Optional<BookEntity> result= bookEntityRepository.findByIdAndBookStatusNot(query.getBookId(),BookStatus.DISCARD)
                                    .stream().findAny();

        if (result.isEmpty()) {
            throw new CloudLibraryException(MessageType.NOT_FOUND);
        }


        return FindBookResult.findByBook(result.get().toBook());

    }

    @Override
    @Transactional
    public OperationBookResult updateBookStatus(BookUpdateStatusCommand command) {

        BookEntity bookEntity = bookEntityRepository.findById(command.getId()).stream().findAny()
                .orElseThrow(() -> new CloudLibraryException(MessageType.NOT_FOUND));

        bookEntity.updateBookStatus(command.getId(),command.getBookStatus());

        return OperationBookResult.requestBook(bookEntity.toBook());
    }

    @Override
    @Transactional
    public void deleteBook(BookDeleteCommand command) {
        BookEntity bookEntity = bookEntityRepository.findById(command.getId()).stream().findAny()
                .orElseThrow(() -> new CloudLibraryException(MessageType.NOT_FOUND));

        bookEntity.changeStatus(BookStatus.DISCARD);

    }
}