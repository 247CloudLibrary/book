package com.cloudlibrary.books.ui.requestBody;

import com.cloudlibrary.books.application.service.BookReadUseCase;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class BookCompositeRequest {

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
    private final String libraryName;
    private final Long categoryId;
    private final Long codeNum;
    private final String codeName;

    public BookCompositeRequest(BookReadUseCase.FindBookResult findBookResult) {
        this.id = findBookResult.getId();
        this.rid = findBookResult.getRid();
        this.isbn = findBookResult.getIsbn();
        this.title = findBookResult.getTitle();
        this.thumbNailImage = findBookResult.getThumbNailImage();
        this.coverImage = findBookResult.getCoverImage();
        this.author = findBookResult.getAuthor();
        this.translator = findBookResult.getTranslator();
        this.contents = findBookResult.getContents();
        this.publisher = findBookResult.getPublisher();
        this.publishDate = findBookResult.getPublishDate();
        this.bookType = findBookResult.getBookType();
        this.genre = findBookResult.getGenre();
        this.barcode = findBookResult.getBarcode();
        this.rfid = findBookResult.getRfid();
        this.bookStatus = findBookResult.getBookStatus();
        this.libraryName = findBookResult.getLibraryName();
        this.categoryId = findBookResult.getCategoryId();
        this.codeNum = findBookResult.getCodeNum();
        this.codeName = findBookResult.getCodeName();
    }
}