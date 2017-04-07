package com.searchdemo.io;

public class IO {
    public static final int TYPE_CONSOLE = 0;
    public static final int TYPE_GUI = 1;
    private static IO instance;
    private IOInterface ioInterface;

    private IO() {}

    private IO(int type) {
        switch (type) {
            case TYPE_CONSOLE:
                ioInterface = new ConsoleIO();
                break;
            case TYPE_GUI:
                ioInterface = null;
                break;
            default:
                ioInterface = null;
                break;
        }
    }

    public static IO getInstance(int type) {
        if (instance == null) {
            instance = new IO(type);
        }
        return instance;
    }

    public IOInterface getInterface() {
        return ioInterface;
    }
}
