package com.cloudlibrary.books.infrastructure.query.http.feign.responseBody;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CompositeResponse {

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
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
