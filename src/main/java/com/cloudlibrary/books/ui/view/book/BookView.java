package com.cloudlibrary.books.ui.view.book;

import com.cloudlibrary.books.application.service.BookReadUseCase;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * TODO 한국십진분류표 code,codeName 추가하기
 */

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookView {
    @ApiModelProperty(value="Book ID")
    private final Long id;
    @ApiModelProperty(value="도서 식별 정보")
    private final String rid;
    @ApiModelProperty(value="국제 표준 도서 번호")
    private final String isbn;
    @ApiModelProperty(value="도서 제목")
    private final String title;
    @ApiModelProperty(value="도서 목록 썸네일 이미지")
    private final String thumbNailImage;
    @ApiModelProperty(value="도서 상세 정보 화면용 표지 이미지")
    private final String coverImage;
    @ApiModelProperty(value="도서 저자")
    private final String author;
    @ApiModelProperty(value="도서 번역가")
    private final String translator;
    @ApiModelProperty(value="도서 줄거리")
    private final String contents;
    @ApiModelProperty(value = "출판사")
    private final String publisher;
    @ApiModelProperty(value="출판일자")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate publishDate;
    @ApiModelProperty(value="자료 종류")
    private final String type;
    @ApiModelProperty(value="도서 장르")
    private final String genre;
    @ApiModelProperty(value="도서 바코드")
    private final String barcode;
    @ApiModelProperty(value="도서 RFID")
    private final String rfid;
    @ApiModelProperty(value="도서 상태")
    private final String bookStatus;
    @ApiModelProperty(value="한국십진분류표 카테고리")
    private final String category;
    @ApiModelProperty(value="도서관 이름")
    private final String libraryName;


    public BookView(BookReadUseCase.FindBookResult result) {
        this.id = result.getId();
        this.rid = result.getRid();
        this.isbn = result.getIsbn();
        this.title = result.getTitle();
        this.thumbNailImage = result.getThumbNailImage();
        this.coverImage = result.getCoverImage();
        this.author = result.getAuthor();
        this.translator = result.getTranslator();
        this.contents = result.getContents();
        this.publisher = result.getPublisher();
        this.publishDate = result.getPublishDate();
        this.type = result.getBookType();
        this.genre = result.getGenre();
        this.barcode = result.getBarcode();
        this.rfid = result.getRfid();
        this.bookStatus = result.getBookStatus();
        this.category = result.getCategory();
        this.libraryName = result.getLibraryName();

    }
}


