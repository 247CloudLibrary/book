package com.cloudlibrary.books.infrastructure.query.http.feign.requestBody;

import com.cloudlibrary.books.application.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CompositeBookStatusRequest {
    private Long id;
    private String bookStatus;

    public CompositeBookStatusRequest(Book book){
        this.id = book.getId();
        this.bookStatus= book.getBookStatus();
    }
}
