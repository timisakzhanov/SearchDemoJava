package com.searchdemo.search;

import com.searchdemo.io.IO;
import com.searchdemo.io.IOInterface;

public class SearchEngine {
    private static IOInterface io;

    public static void startSearch() {
        io = IO.getInstance(IO.TYPE_CONSOLE).getInterface();
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
        int engineType = -1;
        io.writeMessage("Select engine (google - 0, yahoo - 1): ");
        String input = io.readMessage();
        try {
            engineType = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return SearcherFactory.getSearcher(engineType);
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
