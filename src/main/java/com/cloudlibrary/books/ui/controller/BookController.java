package com.cloudlibrary.books.ui.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(value = "도서 API")
@RequestMapping("/v1/books")
public class BookController {
}
