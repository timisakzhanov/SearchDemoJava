package com.searchdemo.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {
    public static Document getContent(URL url) {
        if (url == null) {
            return null;
        }

        try {
            return Jsoup.connect(url.toString()).get();
        } catch (MalformedURLException e) {
            LoggerFactory.getLogger(NetworkUtils.class).error("error" , e.fillInStackTrace());
        } catch (IOException e) {
            LoggerFactory.getLogger(NetworkUtils.class).error("error" , e.fillInStackTrace());
        }
        System.out.println("ok");
        return null;
    }
}
