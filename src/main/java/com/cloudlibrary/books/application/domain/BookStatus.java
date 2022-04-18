package com.cloudlibrary.books.application.domain;


import org.springframework.util.ObjectUtils;

/**
 *   AVAILABLE: 대여 가능
 *   STORAGE: 창고 보관
 *   LOST: 분실
 *   DISCARD: 폐기
 */
public enum BookStatus {
    AVAILABLE("대여가능")
    ,STORAGE("창고보관")
    ,LOST("분실")
    ,DISCARD("폐기")
    ,INVALID("유효하지않음");

    private final String status;

    BookStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }



    public static BookStatus find(String  name) {
        if (ObjectUtils.isEmpty( name)) {
            return INVALID;
        }
        for (BookStatus bookStatus : BookStatus.values()) {
            if (bookStatus.name().equals( name.toUpperCase())) {
                return bookStatus;
            }
        }
        return INVALID;
    }

}