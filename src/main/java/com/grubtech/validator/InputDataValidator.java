package com.grubtech.validator;

import static com.grubtech.exception.ErrorMessages.*;

public class InputDataValidator {

    private static final String POSITION_PATTERN = "^[0-9]+\\s{1}[0-9]+\\s{1}[NEWS]{1}$";

    private static final String COMMAND_PATTERN = "^[MLR]+$";

    private InputDataValidator() {
    }

    public static void validatePositionStr(String positionStr) {
        if (!positionStr.matches(POSITION_PATTERN)) {
            throw new IllegalArgumentException(POSITION_VALIDATION_ERROR_MESSAGE);
        }
    }

    public static void validateOutputStr(String outputStr) {
        if (!outputStr.matches(POSITION_PATTERN)) {
            throw new IllegalArgumentException(OUTPUT_DATA_VALIDATION_ERROR_MESSAGE);
        }
    }

    public static void validateCommandStr(String commandStr) {
        if (!commandStr.matches(COMMAND_PATTERN)) {
            throw new IllegalArgumentException(COMMAND_DATA_VALIDATION_ERROR_MESSAGE);
        }
    }
}
