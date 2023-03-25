package com.urlShortener.Service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/shortnerService")
public class ShortenerServiceController {

    @GetMapping("/getShortenedUrl")
    public String getUrl(){
        return "URL IS WORKING";
    }
}
