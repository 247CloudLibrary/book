package com.cloudlibrary.books.infrastructure.query.http.feign.client;

import com.cloudlibrary.books.infrastructure.configuration.FeignClientConfiguration;
import com.cloudlibrary.books.infrastructure.query.http.feign.requestBody.CompositeRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(
        name = "composite-api",
        url = "${feign.composite-api.url}",
        configuration = {FeignClientConfiguration.class}
)
public interface CompositeRequestClient {

    @PostMapping(value = "/composite", consumes = "application/json")
    void requestBookPost(@RequestBody CompositeRequest request);



}
