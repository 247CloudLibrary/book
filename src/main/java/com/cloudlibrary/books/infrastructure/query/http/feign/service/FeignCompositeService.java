package com.cloudlibrary.books.infrastructure.query.http.feign.service;


import com.cloudlibrary.books.infrastructure.query.http.feign.client.CompositeRequestClient;
import com.cloudlibrary.books.infrastructure.query.http.feign.requestBody.CompositeBookStatusRequest;
import com.cloudlibrary.books.infrastructure.query.http.feign.requestBody.CompositeRequest;
import org.springframework.stereotype.Service;


@Service
public class FeignCompositeService {


    private final CompositeRequestClient compositeRequestClient;

    public FeignCompositeService(CompositeRequestClient compositeRequestClient) {
        this.compositeRequestClient = compositeRequestClient;
    }

    public void requestCompositeBook(CompositeRequest request) {
         compositeRequestClient.requestBookPost(request);
    }


}
