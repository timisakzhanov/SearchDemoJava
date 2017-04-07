package com.searchdemo.search;

public class GoogleSearcher extends BaseSearcher {
    private static GoogleSearcher instance;

    private GoogleSearcher() {
        baseUrl = "http://www.google.com/search?q=";
        resultPattern = "#rso ._NId .srg .g .rc h3 a";
    }

    public static GoogleSearcher getInstance() {
        if (instance == null) {
            instance = new GoogleSearcher();
        }
        return instance;
    }
}
