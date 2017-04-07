package com.searchdemo.search;

/**
 * Created by tim_isakjanov on 4/7/17.
 */
public class SearcherFactory {
    public static Searcher getSearcher(String type) {
        if (type.equals("google")) {
            return GoogleSearcher.getInstance();
        }
        if (type.equals("yahoo")) {
            return YahooSearcher.getInstance();
        }
        return null;
    }
}
