package com.cloudlibrary.books.application.domain;

import com.cloudlibrary.books.exception.CloudLibraryException;
import com.cloudlibrary.books.exception.MessageType;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

/**
 * BOOK: 도서
 * NON_BOOK: 비도서
 */


public enum BookType {
    BOOK("도서")
    ,NON_BOOK("비도서")
    ,INVALID("유효하지않음");


    private final String type;

    BookType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public static BookType find(String name) {
        if (ObjectUtils.isEmpty( name)) {
            return INVALID;
        }
        for (BookType bookType : BookType.values()) {
            if (bookType.name().equals( name.toUpperCase())) {
                return bookType;
            }
        }
    return INVALID;
    }
}


