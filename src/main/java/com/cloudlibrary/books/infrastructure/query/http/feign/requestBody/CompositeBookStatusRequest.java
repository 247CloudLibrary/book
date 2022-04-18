package com.cloudlibrary.books.infrastructure.query.http.feign.requestBody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CompositeBookStatusRequest {
    private String bookStatus;
}
