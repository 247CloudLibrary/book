package com.cloudlibrary.books.infrastructure.persistence.mysql.entity;


/**
 *   AVAILABLE: 대여 가능
 *   STORAGE: 창고 보관
 *   LOST: 분실
 *   DISCARD: 폐기
 */
public enum BookStatusEnum {
        AVAILABLE
    ,STORAGE
    ,LOST
    ,DISCARD
}