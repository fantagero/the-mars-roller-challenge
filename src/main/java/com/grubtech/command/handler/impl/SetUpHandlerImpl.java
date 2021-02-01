package com.grubtech.command.handler.impl;

import com.grubtech.command.handler.CommandBaseHandler;
import com.grubtech.command.handler.CommandHandler;
import com.grubtech.exception.GridPositionBusyException;
import com.grubtech.exception.GridPositionOutOfRangeException;
import com.grubtech.model.DirectionType;
import com.grubtech.model.Grid;
import com.grubtech.model.Point;

import static com.grubtech.util.GridUtils.isPointInRange;
import static com.grubtech.exception.ErrorMessages.*;
import static java.util.Objects.isNull;

public class SetUpHandlerImpl extends CommandBaseHandler {

    public SetUpHandlerImpl(CommandHandler nextHandler) {
        super.nextHandler = nextHandler;
    }

    @Override
    public Grid handle(Grid grid) {
        Point point = grid.getActivePoint();
        DirectionType[][] plateau = grid.getPlateau();
        DirectionType direction = grid.getActiveDirection();

        if (!isPointInRange(point, grid)) {
            throw new GridPositionOutOfRangeException(PROVIDED_COORDINATES_ARE_OUT_OF_GRID_RANGE);

        } else if (plateau[point.getX()][point.getY()] != null) {
            throw new GridPositionBusyException(POSITION_BY_COORDINATES_ARE_ALREADY_BUSY_BY_OTHER_ROVER);
        } else {
            plateau[point.getX()][point.getY()] = direction;
            grid.setPlateau(plateau);
            grid.setActiveDirection(direction);
            grid.setActivePoint(point);
        }

        if (isNull(nextHandler)) {
            return grid;
        }
        return nextHandler.handle(grid);
    }
}
