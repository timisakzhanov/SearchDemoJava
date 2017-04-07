package com.searchdemo.search;

public class Result {
    private String title;
    private String url;
    private String error;

    public Result(String title, String url, String error) {
        this.title = title;
        this.url = url;
        this.error = error;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getError() {
        return error;
    }
}
