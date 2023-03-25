package com.urlShortener.Service.service;

import com.urlShortener.Service.model.UrlEntity;

import java.util.List;

public interface UrlShortenerService {
    List<UrlEntity> getUrls();

    String createUrl(String url);
}
