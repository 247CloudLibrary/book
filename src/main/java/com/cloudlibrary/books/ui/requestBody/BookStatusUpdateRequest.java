package com.cloudlibrary.books.ui.requestBody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookStatusUpdateRequest {
    @NotEmpty(message = "도서 상태는 필수 입력 값입니다")
    private String bookStatus;
}
