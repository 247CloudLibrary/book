package com.cloudlibrary.books.infrastructure.query.http.feign.requestBody;


import com.cloudlibrary.books.application.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CompositeRequest {

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
    private Long libraryId;
    private String libraryName;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CompositeRequest(Book book){
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
        this.category = book.getCategory();
        this.bookStatus = book.getBookStatus();
        this.libraryId = book.getLibraryId();
        this.libraryName = book.getLibraryName();
    }

}
