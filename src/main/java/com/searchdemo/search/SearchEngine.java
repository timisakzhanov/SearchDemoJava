package com.searchdemo.search;

import com.searchdemo.io.ConsoleIO;
import com.searchdemo.io.IOInterface;

public class SearchEngine {
    private IOInterface io;

    public SearchEngine() {
        io = ConsoleIO.getInstance();
    }

    public void startSearch() {
        String input = askForQuery();
        Searcher searcher = selectSearcher();

        if (searcher == null) {
            io.writeMessage("Wrong search engine");
            return;
        }

        Result result = searcher.search(input);
        displayResult(result, io);
    }

    private String askForQuery() {
        io.writeMessage("Enter query: ");
        return io.readMessage();
    }

    private Searcher selectSearcher() {
        io.writeMessage("Select search engine google or yahoo: ");
        String engine = io.readMessage();
        return SearcherFactory.getSearcher(engine);
    }


    private void displayResult(Result result, IOInterface io) {
        if (result == null) {
            return;
        }

        if (result.getError() != null) {
            io.writeMessage("error: " + result.getError());
            return;
        }

        io.writeMessage("title: " + result.getTitle());
        io.writeMessage("url: " + result.getUrl());
    }
}
