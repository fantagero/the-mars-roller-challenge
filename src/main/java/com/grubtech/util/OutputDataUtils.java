package com.grubtech.util;

import com.grubtech.model.Grid;

public class OutputDataUtils {

    private static final String OUTPUT_RESULT_FORMAT = "%s %s %s";

    private OutputDataUtils() {
    }

    public static String formatOutput(Grid grid) {
        return String.format(OUTPUT_RESULT_FORMAT,
                grid.getActivePoint().getX(),
                grid.getActivePoint().getY(),
                grid.getActiveDirection());
    }
}
