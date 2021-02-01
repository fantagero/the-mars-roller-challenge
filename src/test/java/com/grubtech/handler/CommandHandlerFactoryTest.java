package com.grubtech.handler;

import com.grubtech.command.CommandType;
import com.grubtech.command.handler.CommandBaseHandler;
import com.grubtech.command.handler.CommandHandlerFactory;
import com.grubtech.command.handler.impl.MoveHandlerImpl;
import com.grubtech.command.handler.impl.SetUpHandlerImpl;
import com.grubtech.command.handler.impl.SpinLeftHandlerImpl;
import com.grubtech.command.handler.impl.SpinRightHandlerImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static com.grubtech.command.CommandType.*;

public class CommandHandlerFactoryTest {

    private final static CommandType[] TEST_COMMANDS_ARRAY = {M, L, R};

    private final static LinkedList<CommandType> TEST_COMMANDS = new LinkedList<>(List.of(TEST_COMMANDS_ARRAY));

    @Test
    public void createCommandHandler() {
        CommandBaseHandler setUpHandler = (SetUpHandlerImpl) CommandHandlerFactory.createCommandHandler(TEST_COMMANDS);
        CommandBaseHandler moveHandler = (CommandBaseHandler) setUpHandler.getNextHandler();
        Assert.assertTrue("Handler is not instance of MoveHandlerImpl", moveHandler instanceof MoveHandlerImpl);
        CommandBaseHandler spinLHandler = (CommandBaseHandler) moveHandler.getNextHandler();
        Assert.assertTrue("Handler is not instance of SpinLeftHandlerImpl", spinLHandler instanceof SpinLeftHandlerImpl);
        CommandBaseHandler spinRHandler = (CommandBaseHandler) spinLHandler.getNextHandler();
        Assert.assertTrue("Handler is not instance of SpinRightHandlerImpl", spinRHandler instanceof SpinRightHandlerImpl);
    }
}
