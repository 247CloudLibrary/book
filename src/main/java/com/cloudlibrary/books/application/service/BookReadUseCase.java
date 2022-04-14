package com.cloudlibrary.books.application.service;

import com.cloudlibrary.books.application.domain.Book;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BookReadUseCase {


    List<FindBookResult> getBookAllList();
    FindBookResult getBook(BookFindQuery query);


    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Getter
    @ToString
    class BookFindQuery {
        private long bookId;

        public BookFindQuery(long bookId) {
            this.bookId = bookId;
        }
    }



    /**
     * TODO 한국십진분류표 code,codeName 추가하기
     */
    @Builder
    @Getter
    @ToString
    class FindBookResult {
        private final Long id;
        private final String rid;
        private final String isbn;
        private final String title;
        private final String thumbNailImage;
        private final String coverImage;
        private final String author;
        private final String translator;
        private final String contents;
        private final String publisher;
        private final LocalDate publishDate;
        private final String bookType;
        private final String genre;
        private final String barcode;
        private final String rfid;
        private final String bookStatus;
        private final Long libraryId;
        private final String libraryName;
        private final Long category;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;

        public static FindBookResult findByBook(Book book) {
            return FindBookResult.builder()
                    .id(book.getId())
                    .rid(book.getRid())
                    .isbn(book.getIsbn())
                    .title(book.getTitle())
                    .thumbNailImage(book.getThumbNailImage())
                    .coverImage(book.getCoverImage())
                    .author(book.getAuthor())
                    .translator(book.getTranslator())
                    .contents(book.getContents())
                    .publisher(book.getPublisher())
                    .bookType(book.getBookType())
                    .genre(book.getGenre())
                    .barcode(book.getBarcode())
                    .rfid(book.getRfid())
                    .bookStatus(book.getBookStatus())
                    .libraryId(book.getLibraryId())
                    .libraryName(book.getLibraryName())
                    .category(book.getCategory())
                    .createdAt(book.getCreatedAt())
                    .updatedAt(book.getUpdatedAt())
                    .build();
        }
    }
}
