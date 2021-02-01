package com.grubtech.handler.impl;

import com.grubtech.command.handler.CommandHandler;
import com.grubtech.command.handler.impl.SetUpHandlerImpl;
import com.grubtech.exception.GridPositionBusyException;
import com.grubtech.exception.GridPositionOutOfRangeException;
import com.grubtech.model.DirectionType;
import com.grubtech.model.Grid;
import com.grubtech.model.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.grubtech.exception.ErrorMessages.*;
import static com.grubtech.model.DirectionType.N;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SetUpHandlerImplTest {

    private final Grid TEST_GRID = new Grid(3, 3);

    private final Point TEST_POINT_SUCCESS = new Point(2, 2);

    private final Point TEST_OUT_OF_RANGE_POINT = new Point(5, 5);

    private final DirectionType TEST_DIRECTION = N;

    private final CommandHandler unit = new SetUpHandlerImpl(null);

    @Before
    public void setUp() {
        TEST_GRID.setActiveDirection(TEST_DIRECTION);
        TEST_GRID.setActivePoint(TEST_POINT_SUCCESS);
    }

    @Test
    public void testHandle() {
        Grid result = unit.handle(TEST_GRID);

        Assert.assertEquals("Initial direction is not equal to expected", TEST_DIRECTION, result.getActiveDirection());
        Assert.assertEquals("Initial point is not equal to expected", TEST_POINT_SUCCESS, result.getActivePoint());
    }

    @Test
    public void testParseGridDimensionCommandLineMissed() {
        TEST_GRID.setActivePoint(TEST_OUT_OF_RANGE_POINT);
        try {
            unit.handle(TEST_GRID);
            fail("Expected exception has not been thrown");
        } catch (GridPositionOutOfRangeException ex) {
            assertEquals(PROVIDED_COORDINATES_ARE_OUT_OF_GRID_RANGE, ex.getMessage());
        } catch (Exception e) {
            fail("Not expected exception has been caught: " + e);
        }
    }

    @Test
    public void testParseGridDimensionCommandPositionBusy() {
        Grid grid = unit.handle(TEST_GRID);
        try {
            unit.handle(grid);
            fail("Expected exception has not been thrown");
        } catch (GridPositionBusyException ex) {
            assertEquals(POSITION_BY_COORDINATES_ARE_ALREADY_BUSY_BY_OTHER_ROVER, ex.getMessage());
        } catch (Exception e) {
            fail("Not expected exception has been caught: " + e);
        }
    }
}
