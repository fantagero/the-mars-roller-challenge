package com.grubtech.validator;

import org.junit.Test;

import static com.grubtech.exception.ErrorMessages.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class InputDataValidatorTest {

    private static final String[] POSITION_POSITIVE_CASES = {"1 8 N", "100 8 W", "5 55 E", "111 333 S"};

    private static final String[] POSITION_NEGATIVE_CASES = {"", "2 E", "E N", "22 44"};

    private static final String[] COMMAND_POSITIVE_CASES = {"MMLR", "RL"};

    private static final String[] COMMAND_NEGATIVE_CASES = {"", "m", "MM R"};

    private static final String[] OUTPUT_RESULT_POSITIVE_CASES = {"2 3 E", "22 4 N", "4 66 W"};

    private static final String[] OUTPUT_RESULT_NEGATIVE_CASES = {"222", "3 4", "W"};

    @Test
    public void testValidatePositionStrPositiveCases() {
        try {
            for (String pc : POSITION_POSITIVE_CASES) {
                InputDataValidator.validatePositionStr(pc);
            }
        } catch (Exception ex) {
            fail("Unexpected exception has been thrown");
        }
    }

    @Test
    public void testValidatePositionStrNegativeCases() {
        try {
            for (String pc : POSITION_NEGATIVE_CASES) {
                InputDataValidator.validatePositionStr(pc);
            }
            fail("Expected exception has not been thrown");
        } catch (IllegalArgumentException ex) {
            assertEquals(POSITION_VALIDATION_ERROR_MESSAGE, ex.getMessage());
        } catch (Exception e) {
            fail("Not expected exception has been caught: " + e);
        }
    }

    @Test
    public void testValidateCommandStrPositiveCases() {
        try {
            for (String pc : COMMAND_POSITIVE_CASES) {
                InputDataValidator.validateCommandStr(pc);
            }
        } catch (Exception ex) {
            fail("Unexpected exception has been thrown" + ex);
        }
    }

    @Test
    public void testValidateCommandStrNegativeCases() {
        try {
            for (String pc : COMMAND_NEGATIVE_CASES) {
                InputDataValidator.validateCommandStr(pc);
            }
            fail("Expected exception has not been thrown");
        } catch (IllegalArgumentException ex) {
            assertEquals(COMMAND_DATA_VALIDATION_ERROR_MESSAGE, ex.getMessage());
        } catch (Exception e) {
            fail("Not expected exception has been caught: " + e);
        }
    }

    @Test
    public void testValidateOutputStrPositiveCases() {
        try {
            for (String pc : OUTPUT_RESULT_POSITIVE_CASES) {
                InputDataValidator.validateOutputStr(pc);
            }
        } catch (Exception ex) {
            fail("Unexpected exception has been thrown");
        }
    }

    @Test
    public void testValidateOutputStrNegativeCases() {
        try {
            for (String pc : OUTPUT_RESULT_NEGATIVE_CASES) {
                InputDataValidator.validateOutputStr(pc);
            }
            fail("Expected exception has not been thrown");
        } catch (IllegalArgumentException ex) {
            assertEquals(OUTPUT_DATA_VALIDATION_ERROR_MESSAGE, ex.getMessage());
        } catch (Exception e) {
            fail("Not expected exception has been caught: " + e);
        }
    }
}
