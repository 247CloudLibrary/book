package com.cloudlibrary.books.application.domain;

import org.springframework.util.ObjectUtils;

public enum Category{

    GENERAL(0, "총류"),
    PHILOSOPHY(100, "철학"),
    RELIGION(200,"종교"),
    SOCIAL_SCIENCE(300,"사회과학"),
    PURE_SCIENCE(400, "순수과학"),
    TECHNOLOGY(500, "기술과학"),
    ART(600, "예술"),
    LANGUAGE(700, "언어"),
    LITERATURE(800,"문학"),
    HISTORY(900,"역사");

    private final int code;
    private final String value;

    Category(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static Category find(String value) {

        for (Category category : Category.values()) {
            if (category.getValue().equals(value)) {
                return category;
            }
        }
        return null;
        }
    }