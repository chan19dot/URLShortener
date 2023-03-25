package com.urlShortener.Service.repository;

import com.urlShortener.Service.model.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends MongoRepository<UrlEntity, String> {

    Optional<UrlEntity> findOneByShortenedUrl(String shortenedUrl);

}
