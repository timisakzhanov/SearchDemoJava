package com.searchdemo.io;

import java.util.Scanner;

public class ConsoleIO implements IOInterface {
    private Scanner scanner;

    public ConsoleIO() {
        scanner = new Scanner(System.in);
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
