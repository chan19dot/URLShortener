package com.urlShortener.Service.service;

import com.urlShortener.Service.model.UrlEntity;
import com.urlShortener.Service.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    @Autowired
    UrlRepository repository;

    @Override
    public List<UrlEntity> getUrls() {
        return repository.findAll();
    }
    private String shortenUrl(String url){
        return url;
    }

    @Override
    public String createUrl(String url) {
        String shortenUrl = shortenUrl(url);
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setUrl(url);
        urlEntity.setShortenedUrl(shortenUrl);
        urlEntity.setTimestamp(LocalDateTime.now());
        urlEntity.setUuid("123");
        repository.save(urlEntity);
        return shortenUrl;
    }
}
