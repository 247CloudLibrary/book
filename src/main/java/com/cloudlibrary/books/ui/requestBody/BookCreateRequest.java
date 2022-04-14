package com.cloudlibrary.books.ui.requestBody;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookCreateRequest {

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
    private String type;
    private String genre;
    private String barcode;
    private String rfid;
    private String bookStatus;
    private Long categoryId;
    private Long libraryId;
    private String libraryName;

}
