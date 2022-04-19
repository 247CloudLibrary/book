package com.cloudlibrary.books.ui.view.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookCompositeView {
    @ApiModelProperty(value="Book ID")
    private Long id;
    @ApiModelProperty(value="도서 식별 정보")
    private String rid;
    @ApiModelProperty(value="국제 표준 도서 번호")
    private String isbn;
    @ApiModelProperty(value="도서 제목")
    private String title;
    @ApiModelProperty(value="도서 목록 썸네일 이미지")
    private String thumbNailImage;
    @ApiModelProperty(value="도서 상세 정보 화면용 표지 이미지")
    private String coverImage;
    @ApiModelProperty(value="도서 저자")
    private String author;
    @ApiModelProperty(value="도서 번역가")
    private String translator;
    @ApiModelProperty(value="도서 줄거리")
    private String contents;
    @ApiModelProperty(value = "출판사")
    private String publisher;
    @ApiModelProperty(value="출판일자")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    private LocalDate publishDate;
    @ApiModelProperty(value="자료 종류")
    private String type;
    @ApiModelProperty(value="도서 장르")
    private String genre;
    @ApiModelProperty(value="도서 바코드")
    private String barcode;
    @ApiModelProperty(value="도서 RFID")
    private String rfid;
    @ApiModelProperty(value="도서 상태")
    private String bookStatus;
    @ApiModelProperty(value="한국십진분류표 카테고리")
    private String category;
    @ApiModelProperty(value="도서관 이름")
    private String libraryName;

}
