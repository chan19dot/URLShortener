package com.urlShortener.Service.service;

import com.urlShortener.Service.model.UrlEntity;
import com.urlShortener.Service.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;
import java.net.URL;
import java.net.MalformedURLException;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.logging.Logger;


import java.time.LocalDateTime;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    @Autowired
    UrlRepository repository;

    @Override
    public List<UrlEntity> getUrls() {
        return repository.findAll();
    }
    private String shortenUrl(String actualUrl){
        String hashAlgo = "SHA-256";
        try{
            MessageDigest md = MessageDigest.getInstance(hashAlgo);
            byte[] hash = md.digest(actualUrl.getBytes());
            byte[] truncatedHash = new byte[8];
            System.arraycopy(hash, 0, truncatedHash, 0, truncatedHash.length);
            return Base64.getUrlEncoder().encodeToString(truncatedHash);
        }
        catch(NoSuchAlgorithmException ex){
            throw new RuntimeException("Hashing algorithm not supported", ex);
        }
    }

    @Override
    public Map createUrl(String url) {
        Map<String,Object> response = new HashMap();
        if(!validateUrl(url)){
            response.put("error", "please provide a valid URL");
            return response;
        }
        if(url.contains("https://www.")){
            url = url.substring(12);
        }
        String shortenedUrl = shortenUrl(url);
        Optional<UrlEntity> opUrlEntity =  repository.findOneByShortenedUrl(shortenedUrl);
        if(opUrlEntity.isPresent()){
            response.put("isDuplicate", true);
            response.put("shortenedUrl","http://localhost:8080/"+opUrlEntity.get().getShortenedUrl());
            return response;
        }
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setUrl(url);
        urlEntity.setShortenedUrl(shortenedUrl);
        urlEntity.setTimestamp(LocalDateTime.now());
        repository.save(urlEntity);
        response.put("shortenedUrl","http://localhost:8080/"+shortenedUrl);
        return response;
    }

    @Override
    public RedirectView redirectToActualUrl(String shortUrl, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        Optional<UrlEntity> urlEntity =  repository.findOneByShortenedUrl(shortUrl);

        if(urlEntity.isPresent() && (ChronoUnit.MINUTES.between(urlEntity.get().getTimestamp(),LocalDateTime.now())<=5)){
            redirectView.setUrl("https://"+urlEntity.get().getUrl());
        }

        else if(urlEntity.isPresent() && (ChronoUnit.MINUTES.between(urlEntity.get().getTimestamp(),LocalDateTime.now())>60)){
            redirectView.setUrl("http://localhost:3000/linkHasExpired");
        }
        else{
            redirectView.setUrl("http://localhost:3000");
        }
        return redirectView;
    }

    private boolean validateUrl(String url){
        try {
            URL u = new URL(url);
            if (!u.getProtocol().equals("http") && !u.getProtocol().equals("https")) {
                return false;
            }
            u.toURI();
        } catch (MalformedURLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
