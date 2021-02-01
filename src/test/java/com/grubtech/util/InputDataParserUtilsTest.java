package com.grubtech.util;

import com.grubtech.model.DirectionType;
import com.grubtech.model.Grid;
import com.grubtech.model.Point;
import com.grubtech.model.Rover;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.grubtech.exception.ErrorMessages.*;
import static com.grubtech.model.DirectionType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class InputDataParserUtilsTest {

    private final static int TEST_X = 2;

    private final static int TEST_Y = 4;

    private static final List<String> TEST_DATA_GRID_DIMENSION_VALID = Collections.singletonList(
            String.format("%s %s", TEST_X, TEST_Y));

    private static final List<String> TEST_DATA_GRID_DIMENSION_MISSED_COORDINATE = Collections.singletonList("");

    private static final List<String> TEST_DATA_GRID_DIMENSION_INVALID = Collections.singletonList("2 3 2");

    public static final String TEST_COMMANDS = "[M, M, L, R, M]";

    public static final DirectionType TEST_DIRECTION = E;

    private static final List<String> TEST_DATA_ROVER_VALID = Arrays.asList("3 3 E", "MMLRM");

    private static final List<String> TEST_DATA_ROVER_MISSED_COMMAND_LINE = Collections.singletonList("3 3 E");

    private static final Point TEST_POINT = new Point(3, 3);

    @Test
    public void testParseRoversSuccess() {
        List<Rover> result = InputDataParserUtils.parseRovers(TEST_DATA_ROVER_VALID.iterator());

        assertEquals("Got more then 1 rover", 1, result.size());
        assertEquals("Expected direction differs", TEST_DIRECTION, result.get(0).getDirection());
        assertEquals("Expected command line differs", TEST_COMMANDS, result.get(0).getCommands().toString());
        assertEquals("Expected point differs", TEST_POINT, result.get(0).getPoint());
    }

    @Test
    public void parseGridDimensionCommandLineMissed() {
        Iterator<String> iterator = TEST_DATA_ROVER_MISSED_COMMAND_LINE.iterator();
        try {
            InputDataParserUtils.parseRovers(iterator);
            fail("Expected exception has not been thrown");
        } catch (IllegalArgumentException ex) {
            assertEquals(COMMAND_LINE_IS_MISSED, ex.getMessage());
        } catch (Exception e) {
            fail("Not expected exception has been caught: " + e);
        }
    }

    @Test
    public void parseGridDimensionSuccess() {
        Grid result = InputDataParserUtils.parseGridDimension(TEST_DATA_GRID_DIMENSION_VALID.iterator());
        assertEquals("Expected upper right x", TEST_X, result.getUpperRightX());
        assertEquals("Expected upper right y", TEST_Y, result.getUpperRightY());
    }

    @Test
    public void parseGridDimensionMissedCoordinate() {
        Iterator<String> it = TEST_DATA_GRID_DIMENSION_MISSED_COORDINATE.iterator();
        it.next();
        try {
            InputDataParserUtils.parseGridDimension(it);
            fail("Expected exception has not been thrown");
        } catch (IllegalArgumentException ex) {
            assertEquals(UPPER_RIGHT_COORDINATES_ARE_MISSED, ex.getMessage());
        } catch (Exception e) {
            fail("Not expected exception has been caught: " + e);
        }
    }

    @Test
    public void parseGridDimensionInvalid() {
        Iterator<String> iterator = TEST_DATA_GRID_DIMENSION_INVALID.iterator();
        try {
            InputDataParserUtils.parseGridDimension(iterator);
            fail("Expected exception has not been thrown");
        } catch (IllegalArgumentException ex) {
            assertEquals(DIMENSION_UPPER_RIGHT_COORDINATES_ARE_INVALID, ex.getMessage());
        } catch (Exception e) {
            fail("Not expected exception has been caught: " + e);
        }
    }
}
