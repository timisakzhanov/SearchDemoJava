package com.searchdemo.search;

/**
 * Created by tim_isakjanov on 4/7/17.
 */
public class SearcherFactory {
    public static final int TYPE_GOOGLE = 0;
    public static final int TYPE_YAHOO = 1;

    public static Searcher getSearcher(int type) {
        switch (type) {
            case TYPE_GOOGLE:
                return new GoogleSearcher();
            case TYPE_YAHOO:
                return new YahooSearcher();
            default:
                return null;
        }
    }
}
