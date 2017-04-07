package com.searchdemo.search;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public abstract class BaseSearcher implements Searcher {
    private static final String CHARSET = "UTF-8";
    protected String baseUrl;
    protected String resultPattern;

    @Override
    public Result search(String query) {
        URL url = generateUrl(query);
        if (url == null) {
            return new Result(null, null, "Failed to generate url");
        }

        Document document = getContent(url);
        if (document == null) {
            return new Result(null, null, "Failed to get results");
        }

        return parseResponse(document);
    }

    private URL generateUrl(String query) {
        try {
            return new URL(baseUrl + URLEncoder.encode(query, CHARSET));
        } catch (UnsupportedEncodingException e) {
            LoggerFactory.getLogger(GoogleSearcher.class).error("error" , e.fillInStackTrace());
        } catch (MalformedURLException e) {
            LoggerFactory.getLogger(GoogleSearcher.class).error("error" , e.fillInStackTrace());
        }
        return null;
    }

    private Result parseResponse(Document doc) {
        Elements results = doc.select(resultPattern);
        Element first = results.first();
        if (first == null) {
            return new Result(null, null, "Failed to parse response");
        }

        return new Result(first.text(), first.attr("href"), null);
    }

    private Document getContent(URL url) {
        if (url == null) {
            return null;
        }

        try {
            return Jsoup.connect(url.toString()).get();
        } catch (MalformedURLException e) {
            LoggerFactory.getLogger(BaseSearcher.class).error("error" , e.fillInStackTrace());
        } catch (IOException e) {
            LoggerFactory.getLogger(BaseSearcher.class).error("error" , e.fillInStackTrace());
        }
        return null;
    }

}
