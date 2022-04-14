package com.cloudlibrary.books.application.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@ToString
@Builder
public class Book {

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
    private final Long code;
    private final String codeName;

}
