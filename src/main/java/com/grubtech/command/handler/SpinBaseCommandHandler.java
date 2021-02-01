package com.grubtech.command.handler;

import com.grubtech.model.DirectionType;
import com.grubtech.model.Grid;
import com.grubtech.model.Point;

import static java.util.Objects.isNull;

public abstract class SpinBaseCommandHandler extends CommandBaseHandler {

    @Override
    public Grid handle(Grid grid) {
        Point point = grid.getActivePoint();
        DirectionType[][] plateau = grid.getPlateau();

        DirectionType newDirection = spin(grid);
        plateau[point.getX()][point.getY()] = newDirection;
        grid.setActiveDirection(newDirection);

        if (isNull(nextHandler)) {
            return grid;
        }
        return nextHandler.handle(grid);
    }

    protected abstract DirectionType spin(Grid grid);
}
