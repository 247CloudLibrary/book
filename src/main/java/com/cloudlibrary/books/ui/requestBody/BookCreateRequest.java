package com.cloudlibrary.books.ui.requestBody;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookCreateRequest {

    @NotEmpty(message = "isbn은 필수입니다")
    private String isbn;
    @NotEmpty(message = "제목은 필수입니다")
    private String title;
    @NotEmpty(message = "썸네일 이미지는 필수입니다")
    private String thumbNailImage;
    @NotEmpty(message = "커버이미지 필수입니다")
    private String coverImage;
    @NotEmpty(message = "저자는 필수입니다")
    private String author;
    private String translator;
    @NotEmpty(message = "내용은 필수입니다")
    private String contents;
    @NotEmpty(message = "출판사는 필수입니다")
    private String publisher;
    private LocalDate publishDate;
    @NotEmpty(message = "자료 종류(도서/비도서)는 필수입니다")
    private String bookType;
    private String genre;
    @NotEmpty(message = "바코드는 필수입니다")
    private String barcode;
    private String rfid;
    @NotEmpty(message = "도서 상태는 필수입니다")
    private String bookStatus;
    @NotEmpty(message = "카테고리는 필수입니다")
    private String category;
    @NotNull(message ="도서관 id는 필수입니다")
    private Long libraryId;
    @NotEmpty(message = "도서관 이름은 필수입니다")
    private String libraryName;

}
