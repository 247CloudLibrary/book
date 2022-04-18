package com.cloudlibrary.books.application.domain;

import org.springframework.util.ObjectUtils;

public enum BookGenre {
    ACTION("액션")
    ,SF_AND_FANTASY("SF/판타지")
    ,COMEDY("코미디")
    ,ROMANCE("로맨스")
    ,HORROR_AND_THRILLER("공포/스릴러")
    ,OTHERS("기타")
    ,INVALID("유효하지않음");

    private final String genre;

    BookGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre(){
        return genre;
    }


    public static BookGenre find(String  name) {
        if (ObjectUtils.isEmpty( name)) {
            return INVALID;
        }
        for (BookGenre bookGenre : BookGenre.values()) {
            if (bookGenre.name().equals( name.toUpperCase())) {
                return bookGenre;
            }
        }
        return INVALID;
    }

}
