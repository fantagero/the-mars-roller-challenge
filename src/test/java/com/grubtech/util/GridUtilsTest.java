package com.grubtech.util;

import com.grubtech.model.Grid;
import com.grubtech.model.Point;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GridUtilsTest {

    private final Point TEST_POINT_IN_RANGE = new Point(6, 7);

    private final Point TEST_POINT_EDGE_MIN = new Point(0, 0);

    private final Point TEST_POINT_EDGE_MAX = new Point(29, 29);

    private final Grid TEST_GRID = new Grid(30, 30);


    @Test
    public void testIsPointInRangePositive() {
        boolean result = GridUtils.isPointInRange(TEST_POINT_IN_RANGE, TEST_GRID);
        assertTrue("Validation should be success for point in range", result);
    }

    @Test
    public void testIsPointInRangeEdgeMin() {
        boolean result = GridUtils.isPointInRange(TEST_POINT_EDGE_MIN, TEST_GRID);
        assertTrue("Validation should be success for bottom left point", result);
    }

    @Test
    public void testIsPointInRangeEdgeMax() {
        boolean result = GridUtils.isPointInRange(TEST_POINT_EDGE_MAX, TEST_GRID);
        assertTrue("Validation should be success for bottom left point", result);
    }

    @Test
    public void testIsPointInRangeNegativeForAllNulls() {
        boolean result = GridUtils.isPointInRange(null, null);
        assertFalse("Validation should be failed for null input parameters", result);
    }

    @Test
    public void testIsPointInRangeNegativeForPointNull() {
        boolean result = GridUtils.isPointInRange(null, new Grid(3, 3));
        assertFalse("Validation should be failed for null input parameters", result);
    }

    @Test
    public void testIsPointInRangeNegativeForGridNull() {
        boolean result = GridUtils.isPointInRange(new Point(0, 0), null);
        assertFalse("Validation should be failed for null input parameters", result);
    }

}
