package com.urlShortener.Service.controller;

import com.urlShortener.Service.model.UrlEntity;
import com.urlShortener.Service.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ShortenerServiceController {

    @Autowired
    UrlShortenerService urlShortenerService;

    @PostMapping("/getShortenedUrl")
    public Map getUrl(@RequestBody() Map<String,String>params){
        return urlShortenerService.createUrl(params.get("url"));
    }

    @GetMapping("/{shortenedUrl}")
    public RedirectView gotoUrl(@PathVariable String shortenedUrl, HttpServletRequest request){
        return urlShortenerService.redirectToActualUrl(shortenedUrl, request);
    }

    @GetMapping("/finAll")
    public List<UrlEntity> getAll(){
        return urlShortenerService.getUrls();
    }

}
