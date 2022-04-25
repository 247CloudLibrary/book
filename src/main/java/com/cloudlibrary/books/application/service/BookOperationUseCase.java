package com.cloudlibrary.books.application.service;

import com.cloudlibrary.books.application.domain.Book;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

public interface BookOperationUseCase {
    void createBook(BookCreateCommand command);
    void updateBook(BookUpdateCommand command);
    void updateBookStatus(BookUpdateStatusCommand command);
    void deleteBook(BookDeleteCommand command);

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BookCreateCommand {
        private String rid;
        private String isbn;
        private String title;
        private String thumbNailImage;
        private String coverImage;
        private String author;
        private String translator;
        private String contents;
        private String publisher;
        private LocalDate publishDate;
        private String bookType;
        private String genre;
        private String barcode;
        private String rfid;
        private String bookStatus;
        private String category;
        private Long libraryId;
        private String libraryName;

    }

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BookUpdateCommand{
        private Long id;
        private String rid;
        private String isbn;
        private String title;
        private String thumbNailImage;
        private String coverImage;
        private String author;
        private String translator;
        private String contents;
        private String publisher;
        private LocalDate publishDate;
        private String bookType;
        private String genre;
        private String barcode;
        private String rfid;
        private String bookStatus;
        private String category;
        private Long libraryId;
        private String libraryName;

        public static Book toBook(BookUpdateCommand command){
            return Book.builder()
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
        }

    }

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BookDeleteCommand{
        private Long id;
    }

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BookUpdateStatusCommand {
        private Long id;
        private String bookStatus;
    }

}
