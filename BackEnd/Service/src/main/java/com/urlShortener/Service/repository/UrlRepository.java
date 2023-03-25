package com.urlShortener.Service.repository;

import com.urlShortener.Service.model.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<UrlEntity, String> {

}
