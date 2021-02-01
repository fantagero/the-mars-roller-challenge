package com.grubtech.util;

import com.grubtech.model.DirectionType;
import static com.grubtech.model.DirectionType.*;

public class DirectionUtils {

    private DirectionUtils() {
    }

    public static DirectionType spinRight(DirectionType direction) {
        switch (direction) {
            case N:
                return E;
            case E:
                return S;
            case S:
                return W;
            case W:
                return N;
            default:
                throw new IllegalArgumentException("Direction is not supported by enumeration");
        }
    }

    public static DirectionType spinLeft(DirectionType direction) {
        switch (direction) {
            case N:
                return W;
            case E:
                return N;
            case S:
                return E;
            case W:
                return S;
            default:
                throw new IllegalArgumentException("Direction is not supported by enumeration");
        }
    }
}
