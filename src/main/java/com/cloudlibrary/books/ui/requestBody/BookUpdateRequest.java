package com.cloudlibrary.books.ui.requestBody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookUpdateRequest {


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
    private Long categoryId;
    private String libraryName;

}
