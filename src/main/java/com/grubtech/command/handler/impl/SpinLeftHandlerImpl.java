package com.grubtech.command.handler.impl;

import com.grubtech.command.handler.CommandHandler;
import com.grubtech.command.handler.SpinBaseCommandHandler;
import com.grubtech.model.DirectionType;
import com.grubtech.model.Grid;
import com.grubtech.util.DirectionUtils;

public class SpinLeftHandlerImpl extends SpinBaseCommandHandler {

    public SpinLeftHandlerImpl(CommandHandler nextHandler) {
        super.nextHandler = nextHandler;
    }

    @Override
    protected DirectionType spin(Grid grid) {
        return DirectionUtils.spinLeft(grid.getActiveDirection());
    }
}
