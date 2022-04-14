package com.cloudlibrary.books.application.service;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

public interface BookOperationUseCase {

    void deleteBook(BookDeleteCommand command);

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BookDeleteCommand{
        private Long id;
    }
}
