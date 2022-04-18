package com.cloudlibrary.books.ui.controller;


import com.cloudlibrary.books.application.service.BookOperationUseCase;
import com.cloudlibrary.books.application.service.BookReadUseCase;
import com.cloudlibrary.books.exception.CloudLibraryException;
import com.cloudlibrary.books.exception.MessageType;
import com.cloudlibrary.books.application.domain.BookStatus;
import com.cloudlibrary.books.application.domain.BookType;
import com.cloudlibrary.books.ui.requestBody.BookCreateRequest;
import com.cloudlibrary.books.infrastructure.query.http.feign.requestBody.CompositeBookStatusRequest;
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

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("good");
    }

    @PostMapping("/books")
    @ApiOperation(value = "도서 등록")
    public ResponseEntity<Void> createBook(@RequestBody BookCreateRequest request) {

        if (ObjectUtils.isEmpty(request)) {
            throw new CloudLibraryException(MessageType.BAD_REQUEST);
        }

        /**
         * rid: library name - author - title
         * TODO 고유하게 만드는 법 생각해 보기
         */

        String[] ridArray = {request.getLibraryName(), request.getTitle(), request.getAuthor()};

        String ridResult = "";

        for (String str : ridArray) {
            String result = str.replaceAll(" ","");
            ridResult += result+"-";
        }


        var command = BookOperationUseCase.BookCreateCommand.builder()
                .rid(ridResult.substring(0,ridResult.length()-1))
                .isbn(request.getIsbn())
                .title(request.getTitle())
                .thumbNailImage(request.getThumbNailImage())
                .coverImage(request.getCoverImage())
                .author(request.getAuthor())
                .translator(request.getTranslator())
                .contents(request.getContents())
                .publisher(request.getPublisher())
                .publishDate(request.getPublishDate())
                .bookType(request.getBookType())
                .genre(request.getGenre())
                .barcode(request.getBarcode())
                .rfid(request.getRfid())
                .bookStatus(request.getBookStatus())
                .category(request.getCategory())
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
               .bookType(BookType.valueOf(request.getBookType().toUpperCase()).name())
               .genre(request.getGenre())
               .barcode(request.getBarcode())
               .rfid(request.getRfid())
               .bookStatus(BookStatus.valueOf(request.getBookStatus().toUpperCase()).name())
               .category(request.getCategory())
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
}
