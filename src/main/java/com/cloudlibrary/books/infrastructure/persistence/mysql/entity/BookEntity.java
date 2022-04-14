package com.cloudlibrary.books.infrastructure.persistence.mysql.entity;


import com.cloudlibrary.books.application.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookEntity implements Serializable {
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
    private String libraryName;
    private Long categoryId;
    private Long code;
    private String codeName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Book toBook() {
        return Book.builder()
                .id(this.id)
                .rid(this.rid)
                .isbn(this.isbn)
                .title(this.title)
                .thumbNailImage(this.thumbNailImage)
                .coverImage(this.coverImage)
                .author(this.author)
                .translator(this.translator)
                .contents(this.contents)
                .publisher(this.publisher)
                .publishDate(this.publishDate)
                .bookType(this.bookType)
                .genre(this.genre)
                .barcode(this.barcode)
                .rfid(this.rfid)
                .bookStatus(this.bookStatus)
                .libraryName(this.libraryName)
                .categoryId(this.categoryId)
                .code(this.code)
                .codeName(this.codeName)
                .build();
    }

    public BookEntity(Book book) {
        this.id = book.getId();
        this.rid = book.getRid();
        this.isbn =book.getIsbn();
        this.title= book.getTitle();
        this.thumbNailImage=book.getThumbNailImage();
        this.coverImage = book.getCoverImage();
        this.author = book.getAuthor();
        this.translator = book.getTranslator();
        this.contents = book.getContents();
        this.publisher = book.getPublisher();
        this.publishDate = book.getPublishDate();
        this.bookType = book.getBookType();
        this.genre = book.getGenre();
        this.barcode = book.getBarcode();
        this.rfid = book.getRfid();
        this.bookStatus = book.getBookStatus();
        this.libraryName = book.getLibraryName();
        this.categoryId = book.getCategoryId();
        this.code =book.getCode();
        this.codeName =book.getCodeName();
    }

}
