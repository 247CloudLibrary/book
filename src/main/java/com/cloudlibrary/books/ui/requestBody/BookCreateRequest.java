package com.cloudlibrary.books.ui.requestBody;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookCreateRequest {

    @NotEmpty(message = "isbn은 필수 입력 값입니다")
    private String isbn;

    @NotEmpty(message = "제목은 필수 입력 값입니다")
    private String title;

    @NotEmpty(message = "도서 목록 썸네일 이미지는 필수 입력 값입니다")
    private String thumbNailImage;

    @NotEmpty(message = " 도서 상세 정보 화면용 표지 이미지는 필수 입력 값입니다")
    private String coverImage;

    @NotEmpty(message = " 저자는 필수 입력 값입니다")
    private String author;

    private String translator;

    @NotEmpty(message = "도서 줄거리는 필수 입력 값입니다")
    private String contents;

    @NotEmpty(message = "출판사는 필수 입력 값입니다")
    private String publisher;

    private LocalDate publishDate;

    @NotEmpty(message = "도서 타입은 필수 입력 값입니다")
    private String bookType;

    @NotEmpty(message = "장르는 필수 입력 값입니다")
    private String genre;

    @NotEmpty(message = "바코드는 필수 입력 값입니다")
    private String barcode;

    private String rfid;

    @NotEmpty(message = "도서 상태는 필수 입력 값입니다")
    private String bookStatus;


    @NotNull(message = "한국십진분류표 코드 번호는 필수 입력 값입니다")
    private Long categoryId;

    @NotEmpty(message = "도서관 이름은 필수 입력 값입니다")
    private String libraryName;

}
