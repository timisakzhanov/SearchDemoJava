package com.searchdemo.search;

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
public class YahooSearcher extends BaseSearcher {
    private static YahooSearcher instance;

    private YahooSearcher() {
        baseUrl = "https://search.yahoo.com/search?p=";
        resultPattern = "#web .mb-15 li h3 a";
    }

    public static YahooSearcher getInstance() {
        if (instance == null) {
            instance = new YahooSearcher();
        }
        return instance;
    }
}
