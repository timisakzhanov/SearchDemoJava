package com.searchdemo.search;

import com.searchdemo.io.ConsoleIO;
import com.searchdemo.io.IOInterface;

public class SearchEngine {
    private static IOInterface io;

    public static void startSearch() {
        io = ConsoleIO.getInstance();
        String input = askForQuery();
        Searcher searcher = selectSearcher();

        if (searcher == null) {
            io.writeMessage("Wrong search engine");
            return;
        }

        Result result = searcher.search(input);
        displayResult(result, io);
    }

    private static String askForQuery() {
        io.writeMessage("Enter query: ");
        return io.readMessage();
    }

    private static Searcher selectSearcher() {
        io.writeMessage("Select search engine google or yahoo: ");
        String engine = io.readMessage();
        return SearcherFactory.getSearcher(engine);
    }


    private static void displayResult(Result result, IOInterface io) {
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
