package com.grubtech.util;

import com.grubtech.model.Grid;
import com.grubtech.model.Point;

import static java.util.Objects.isNull;

public class GridUtils {

    private GridUtils() {
    }

    public static boolean isPointInRange(Point point, Grid grid) {
        if (isNull(grid) || isNull(point)) {
            return false;
        }

        return point.getY() <= grid.getUpperRightY() &&
                point.getX() <= grid.getUpperRightX() &&
                point.getY() >= 0 &&
                point.getX() >= 0;
    }

}
