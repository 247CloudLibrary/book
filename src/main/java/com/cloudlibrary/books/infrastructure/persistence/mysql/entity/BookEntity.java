package com.cloudlibrary.books.infrastructure.persistence.mysql.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * TODO 한국십진분류표 code, codeName 추가
 */
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

}
