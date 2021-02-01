package com.grubtech.command.handler;

import com.grubtech.command.CommandType;
import com.grubtech.command.handler.impl.MoveHandlerImpl;
import com.grubtech.command.handler.impl.SetUpHandlerImpl;
import com.grubtech.command.handler.impl.SpinLeftHandlerImpl;
import com.grubtech.command.handler.impl.SpinRightHandlerImpl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CommandHandlerFactory {

    private CommandHandlerFactory() {
    }

    public static CommandHandler createCommandHandler(List<CommandType> commands) {
        CommandHandler currentHandler = null;
        Iterator<CommandType> itr = new LinkedList<>(commands).descendingIterator();
        while (itr.hasNext()) {
            CommandType command = itr.next();
            switch (command) {
                case M:
                    currentHandler = new MoveHandlerImpl(currentHandler);
                    break;
                case R:
                    currentHandler = new SpinRightHandlerImpl(currentHandler);
                    break;
                case L:
                    currentHandler = new SpinLeftHandlerImpl(currentHandler);
                    break;
            }
        }
        return new SetUpHandlerImpl(currentHandler);
    }
}
