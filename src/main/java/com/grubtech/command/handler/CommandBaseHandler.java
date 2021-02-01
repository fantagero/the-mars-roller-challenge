package com.grubtech.command.handler;

public abstract class CommandBaseHandler implements CommandHandler {

    protected CommandHandler nextHandler;

    public CommandHandler getNextHandler() {
        return nextHandler;
    }
}
