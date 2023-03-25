package com.urlShortener.Service.service;

import com.urlShortener.Service.model.UrlEntity;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UrlShortenerService {
    List<UrlEntity> getUrls();

    Map createUrl(String url);

    RedirectView redirectToActualUrl(String url, HttpServletRequest request);
}
