package com.grubtech.util;

import com.grubtech.model.DirectionType;
import com.grubtech.model.Grid;
import com.grubtech.model.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OutputDataUtilsTest {

    private static final int x = 22;

    private static final int y = 3;

    private static final DirectionType d = DirectionType.E;

    private static final String EXPECTED_OUTPUT_RESULT = "22 3 E";

    @Test
    public void testFormatOutput() {
        Grid grid = new Grid(30, 30);
        grid.setActivePoint(new Point(x, y));
        grid.setActiveDirection(d);

        String result = OutputDataUtils.formatOutput(grid);

        assertEquals("Expected output result doesn't match", EXPECTED_OUTPUT_RESULT, result);
    }
}
