package com.cloudlibrary.books.ui.controller;


import com.cloudlibrary.books.application.service.BookOperationUseCase;
import com.cloudlibrary.books.application.service.BookReadUseCase;
import com.cloudlibrary.books.exception.CloudLibraryException;
import com.cloudlibrary.books.exception.MessageType;
import com.cloudlibrary.books.infrastructure.persistence.mysql.entity.BookStatusEnum;
import com.cloudlibrary.books.infrastructure.persistence.mysql.entity.BookTypeEnum;
import com.cloudlibrary.books.ui.requestBody.BookCreateRequest;
import com.cloudlibrary.books.ui.requestBody.BookStatusUpdateRequest;
import com.cloudlibrary.books.ui.requestBody.BookUpdateRequest;
import com.cloudlibrary.books.ui.view.ApiResponseView;
import com.cloudlibrary.books.ui.view.book.BookCompositeView;
import com.cloudlibrary.books.ui.view.book.BookView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
@Api(value = "도서 API")
@RequestMapping("/v1")
public class BookController {

    private final BookReadUseCase bookReadUseCase;
    private final BookOperationUseCase bookOperationUseCase;

    public BookController(BookReadUseCase bookReadUseCase, BookOperationUseCase bookOperationUseCase) {
        this.bookReadUseCase = bookReadUseCase;
        this.bookOperationUseCase = bookOperationUseCase;
    }

    @PostMapping("/books")
    @ApiOperation(value = "도서 등록")
    public ResponseEntity<Void> createBook(@RequestBody BookCreateRequest request) {

        if (ObjectUtils.isEmpty(request)) {
            throw new CloudLibraryException(MessageType.BAD_REQUEST);
        }

        /**
         * TODO rid만들기 library name - author - title - id조합 --> 등록할때 id없음..
         */

        var command = BookOperationUseCase.BookCreateCommand.builder()
                .rid(request.getLibraryName()+'-'+request.getTitle()+'-'+request.getAuthor())
                .isbn(request.getIsbn())
                .title(request.getTitle())
                .thumbNailImage(request.getThumbNailImage())
                .coverImage(request.getCoverImage())
                .author(request.getAuthor())
                .translator(request.getTranslator())
                .contents(request.getContents())
                .publisher(request.getPublisher())
                .publishDate(request.getPublishDate())
                .bookType(BookTypeEnum.valueOf(request.getBookType().toUpperCase()).name())
                .genre(request.getGenre())
                .barcode(request.getBarcode())
                .rfid(request.getRfid())
                .bookStatus(BookStatusEnum.valueOf(request.getBookStatus().toUpperCase()).name())
                .categoryId(request.getCategoryId())
                .libraryName(request.getLibraryName()).build();

        bookOperationUseCase.createBook(command);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/books")
    @ApiOperation(value = "도서 목록 조회")
    public ResponseEntity<ApiResponseView<List<BookView>>> getBooksAll() {

        var results = bookReadUseCase.getBookAllList();

        return ResponseEntity.ok(new ApiResponseView<>(results.stream().map(BookView::new).collect(Collectors.toList())));
    }

    @GetMapping("/books/{id}")
    @ApiOperation(value = "도서 상세 조회")
    public ResponseEntity<ApiResponseView<BookView>> getBook(@PathVariable("id") Long id) {

        var query = new BookReadUseCase.BookFindQuery(id);

        var result = bookReadUseCase.getBook(query);

        return ResponseEntity.ok(new ApiResponseView<>(new BookView(result)));
    }


    @PutMapping("/books/{id}")
    @ApiOperation(value = "도서 수정")
    public ResponseEntity<ApiResponseView<Long>> updateBook(@PathVariable("id") Long id, @RequestBody BookUpdateRequest request) {
      var command = BookOperationUseCase.BookUpdateCommand.builder()
               .id(id)
               .rid(request.getRid())
               .isbn(request.getIsbn())
               .title(request.getTitle())
               .thumbNailImage(request.getThumbNailImage())
               .coverImage(request.getCoverImage())
               .author(request.getAuthor())
               .translator(request.getTranslator())
               .contents(request.getContents())
               .publisher(request.getPublisher())
               .publishDate(request.getPublishDate())
               .bookType(BookTypeEnum.valueOf(request.getBookType().toUpperCase()).name())
               .genre(request.getGenre())
               .barcode(request.getBarcode())
               .rfid(request.getRfid())
               .bookStatus(BookStatusEnum.valueOf(request.getBookStatus().toUpperCase()).name())
               .categoryId(request.getCategoryId())
               .libraryName(request.getLibraryName()).build();

        var result = bookOperationUseCase.updateBook(command);

        return ResponseEntity.ok(new ApiResponseView<>(result));
    }


    @PatchMapping("/books/{id}")
    @ApiOperation(value="도서 삭제. bookStatus를 DISCARD로 변경")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){

        var command = BookOperationUseCase.BookDeleteCommand.builder().id(id).build();

        bookOperationUseCase.deleteBook(command);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/composite")
    @ApiOperation(value = "컴포짓에 도서 정보 전달")
    public ResponseEntity<ApiResponseView<BookCompositeView>> createBookToComposite(@RequestBody BookCreateRequest request){
//
//        BookCompositeView mockResult = BookCompositeView.builder()
//                .id(1L)
//                .rid(request.getLibraryName() + "-" + request.getAuthor() + "-" + request.getTitle() + "_" + 1L)
//                .isbn("isbnTEST1234")
//                .title(request.getTitle())
//                .thumbNailImage(request.getThumbNailImage())
//                .coverImage(request.getCoverImage())
//                .author(request.getAuthor())
//                .translator(request.getTranslator())
//                .publisher(request.getPublisher())
//                .publishDate(request.getPublishDate())
//                .type(request.getType())
//                .genre(request.getGenre())
//                .barcode(request.getBarcode())
//                .rfid(request.getRfid())
//                .bookStatus(request.getBookStatus())
//                .category(request.getCategory())
//                .libraryId(request.getLibraryId())
//                .libraryName(request.getLibraryName()).build();

        return null;
    }

    @PatchMapping("/composite/bookstatus/{id}")
    @ApiOperation(value="도서 상태 변경")
    public ResponseEntity<ApiResponseView<BookCompositeView>> updateBookStatusToComposite(@PathVariable Long id,@RequestBody BookStatusUpdateRequest request){

//        BookCompositeView mockResult = BookCompositeView.builder()
//                .id(id)
//                .rid("도서관명-작가-책이름" + 1L)
//                .isbn("isbnTEST1234")
//                .title("책이름")
//                .thumbNailImage("썸네일 이미지")
//                .coverImage("커버이미지")
//                .author("저자")
//                .translator("번역가")
//                .publisher("출판사")
//                .publishDate(LocalDate.of(2022,05,02))
//                .type("비도서")
//                .genre("장르")
//                .barcode("바코드123")
//                .rfid("rfid1234")
//                .bookStatus(request.getBookStatus())
//                .category(100L)
//                .libraryId(1L)
//                .libraryName("도서관이름").build();

        return null;

    }
}
