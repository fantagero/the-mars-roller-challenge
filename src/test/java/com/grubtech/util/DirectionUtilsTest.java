package com.grubtech.util;

import com.grubtech.model.DirectionType;
import org.junit.Test;

import java.util.Map;

import static com.grubtech.model.DirectionType.*;
import static org.junit.Assert.assertEquals;

public class DirectionUtilsTest {

    public static final Map<DirectionType, DirectionType> SPIN_RIGHT_TEST_DATA = Map.of(
            N, E,
            E, S,
            S, W,
            W, N);

    public static final Map<DirectionType, DirectionType> SPIN_LEFT_TEST_DATA = Map.of(
            E, S,
            S, W,
            W, N,
            N, E);

    @Test
    public void testSpinRight() {
        for (DirectionType k : SPIN_RIGHT_TEST_DATA.keySet()) {
            assertEquals("Expected and actual results for spin right doesn't match",
                    SPIN_RIGHT_TEST_DATA.get(k), DirectionUtils.spinRight(k));
        }
    }

    @Test
    public void testSpinLeft() {
        for (DirectionType k : SPIN_LEFT_TEST_DATA.keySet()) {
            assertEquals("Expected and actual results for spin left doesn't match",
                    SPIN_LEFT_TEST_DATA.get(k), DirectionUtils.spinRight(k));
        }
    }
}
