package com.urlShortener.Service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("urls")
@NoArgsConstructor
@Data
public class UrlEntity {

    @Id
    private String id;
    private String url;
    private String shortenedUrl;
    private LocalDateTime timestamp;
    private String uuid;
}
