package com.grubtech.exception;

public class ErrorMessages {

    private ErrorMessages() {
    }

    public static final String POSITION_VALIDATION_ERROR_MESSAGE = "Position data is incorrect";

    public static final String OUTPUT_DATA_VALIDATION_ERROR_MESSAGE = "Output data is incorrect";

    public static final String COMMAND_DATA_VALIDATION_ERROR_MESSAGE = "Command data is incorrect";

    public static final String UPPER_RIGHT_COORDINATES_ARE_MISSED = "Upper-right coordinates are missed";

    public static final String DIMENSION_UPPER_RIGHT_COORDINATES_ARE_INVALID = "Dimension upper-right coordinates are invalid";

    public static final String COMMAND_LINE_IS_MISSED = "Command line is missed";

    public static final String PROVIDED_COORDINATES_ARE_OUT_OF_GRID_RANGE = "Provided coordinates are out of grid range";

    public static final String POSITION_BY_COORDINATES_ARE_ALREADY_BUSY_BY_OTHER_ROVER = "Position by coordinates are already busy by other rover";

}