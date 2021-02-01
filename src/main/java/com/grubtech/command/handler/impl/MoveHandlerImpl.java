package com.grubtech.command.handler.impl;

import com.grubtech.command.handler.CommandBaseHandler;
import com.grubtech.command.handler.CommandHandler;
import com.grubtech.exception.GridPositionBusyException;
import com.grubtech.exception.GridPositionOutOfRangeException;
import com.grubtech.model.DirectionType;
import com.grubtech.model.Grid;
import com.grubtech.model.Point;

import static com.grubtech.util.GridUtils.isPointInRange;
import static java.util.Objects.isNull;

public class MoveHandlerImpl extends CommandBaseHandler {

    public MoveHandlerImpl(CommandHandler nextHandler) {
        super.nextHandler = nextHandler;
    }

    @Override
    public Grid handle(Grid grid) {
        Point point = grid.getActivePoint();
        DirectionType[][] plateau = grid.getPlateau();

        DirectionType direction = plateau[point.getX()][point.getY()];
        Point newPoint = getNewPosition(direction, point);

        if (!isPointInRange(point, grid)) {
            throw new GridPositionOutOfRangeException("Provided coordinates are out of grid range");
        } else if (plateau[newPoint.getX()][newPoint.getY()] != null) {
            throw new GridPositionBusyException("Position by coordinates are already busy by other rover");
        } else {
            plateau[point.getX()][point.getY()] = null;
            plateau[newPoint.getX()][newPoint.getY()] = direction;

            grid.setActivePoint(newPoint);
        }

        if (isNull(nextHandler)) {
            return grid;
        }
        return nextHandler.handle(grid);
    }

    private static Point getNewPosition(DirectionType direction, Point point) {
        switch (direction) {
            case N:
                return new Point(point.getX(), point.getY() + 1);
            case E:
                return new Point(point.getX() + 1, point.getY());
            case S:
                return new Point(point.getX(), point.getY() - 1);
            case W:
                return new Point(point.getX() - 1, point.getY());
            default:
                throw new IllegalArgumentException("Direction is not supported by enumeration");
        }
    }
}
