package com.searchdemo.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class NetworkUtils {
    public static Document getContent(URL url) {
        if (url == null) {
            return null;
        }

        try {
            return Jsoup.connect(url.toString()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
