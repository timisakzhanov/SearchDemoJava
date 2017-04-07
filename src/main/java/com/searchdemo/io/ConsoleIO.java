package com.searchdemo.io;

import java.util.Scanner;

public class ConsoleIO implements IOInterface {
    private static ConsoleIO instance;
    private Scanner scanner;

    private ConsoleIO() {
        scanner = new Scanner(System.in);
    }

    public static ConsoleIO getInstance() {
        if (instance == null) {
            instance = new ConsoleIO();
        }
        return instance;
    }

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String readMessage() {
        return scanner.nextLine();
    }
}
