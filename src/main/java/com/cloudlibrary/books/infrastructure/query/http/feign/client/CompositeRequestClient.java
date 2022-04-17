package com.cloudlibrary.books.infrastructure.query.http.feign.client;

import com.cloudlibrary.books.infrastructure.configuration.FeignClientConfiguration;
import com.cloudlibrary.books.infrastructure.query.http.feign.requestBody.CompositeBookStatusRequest;
import com.cloudlibrary.books.infrastructure.query.http.feign.requestBody.CompositeRequest;
import com.cloudlibrary.books.infrastructure.query.http.feign.responseBody.CompositeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@FeignClient(
        name = "composite-api",
        url = "${feign.composite-api.url}",
        configuration = {FeignClientConfiguration.class})
public interface CompositeRequestClient {

    @PostMapping(value = "/composite", consumes = "application/json")
    Optional<CompositeResponse> requestBookPost(CompositeRequest request);

    @PatchMapping(value = "/bookstatus/{bookId}", consumes = "application/json")
    Optional<CompositeResponse> requestBookStatusUpdate(@PathVariable Long bookId, CompositeBookStatusRequest request);

}
