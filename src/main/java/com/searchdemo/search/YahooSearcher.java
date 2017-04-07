package com.searchdemo.search;

import com.searchdemo.utils.NetworkUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by tim_isakjanov on 4/7/17.
 */
public class YahooSearcher implements Searcher {
    private static final String BASE_URL = "https://search.yahoo.com/search?p=";
    private static final String CHARSET = "UTF-8";
    private static YahooSearcher instance;

    private YahooSearcher() {}

    public static YahooSearcher getInstance() {
        if (instance == null) {
            instance = new YahooSearcher();
        }
        return instance;
    }

    @Override
    public Result search(String query) {
        URL url = generateUrl(query);
        if (url == null) {
            return new Result(null, null, "Failed to generate url");
        }

        Document document = NetworkUtils.getContent(url);
        if (document == null) {
            return new Result(null, null, "Failed to get results");
        }

        return parseResponse(document);
    }

    private URL generateUrl(String query) {
        try {
            return new URL(BASE_URL + URLEncoder.encode(query, CHARSET));
        } catch (UnsupportedEncodingException e) {
            LoggerFactory.getLogger(YahooSearcher.class).error("error" , e.fillInStackTrace());
        } catch (MalformedURLException e) {
            LoggerFactory.getLogger(YahooSearcher.class).error("error" , e.fillInStackTrace());
        }
        return null;
    }

    private Result parseResponse(Document doc) {
        Elements results = doc.select("#web .mb-15 li h3 a");
        Element first = results.first();
        if (first == null) {
            return new Result(null, null, "Failed to parse response");
        }

        return new Result(first.text(), first.attr("href"), null);
    }
}
