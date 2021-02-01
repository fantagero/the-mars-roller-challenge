package com.grubtech.handler.impl;

import com.grubtech.command.handler.CommandHandler;
import com.grubtech.command.handler.impl.SpinLeftHandlerImpl;
import com.grubtech.model.DirectionType;
import com.grubtech.model.Grid;
import com.grubtech.model.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.grubtech.model.DirectionType.S;
import static com.grubtech.model.DirectionType.W;

public class SpinLeftHandlerImplTest {

    private final Grid TEST_GRID = new Grid(3, 3);

    private final Point TEST_POINT_SUCCESS = new Point(2, 2);

    private final DirectionType TEST_DIRECTION = W;

    private final DirectionType EXPECTED_DIRECTION = S;

    private final DirectionType[][] TEST_PLATEAU = {{null, null, null}, {null, null, null}, {null, null, TEST_DIRECTION}};

    private final CommandHandler unit = new SpinLeftHandlerImpl(null);

    @Before
    public void setUp() {
        TEST_GRID.setActiveDirection(TEST_DIRECTION);
        TEST_GRID.setActivePoint(TEST_POINT_SUCCESS);
        TEST_GRID.setPlateau(TEST_PLATEAU);
    }

    @Test
    public void testSpinLeft() {
        Grid result = unit.handle(TEST_GRID);

        Assert.assertEquals("Initial direction is not equal to expected", EXPECTED_DIRECTION, result.getActiveDirection());
        Assert.assertEquals("Initial point is not equal to expected", TEST_POINT_SUCCESS, result.getActivePoint());
    }

}
