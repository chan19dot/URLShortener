package com.urlShortener.Service.controller;

import com.urlShortener.Service.model.UrlEntity;
import com.urlShortener.Service.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class ShortenerServiceController {

    @Autowired
    UrlShortenerService urlShortenerService;

    @PostMapping("/getShortenedUrl/{url}")
    public String getUrl(@PathVariable String url){
        System.out.println(url);
        return "URL IS WORKING";
    }

    @GetMapping("/redirect/{id}")
    public RedirectView gotoId(@PathVariable String id){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("https://"+id);
        return redirectView;
    }

    @GetMapping("/finAll")
    public List<UrlEntity> getAll(){
        return urlShortenerService.getUrls();
    }
}
