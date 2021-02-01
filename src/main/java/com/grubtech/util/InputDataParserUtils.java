package com.grubtech.util;

import com.grubtech.command.CommandType;
import com.grubtech.model.DirectionType;
import com.grubtech.model.Grid;
import com.grubtech.model.Point;
import com.grubtech.model.Rover;

import java.util.*;
import java.util.stream.Collectors;

import static com.grubtech.exception.ErrorMessages.*;
import static com.grubtech.validator.InputDataValidator.validateCommandStr;
import static com.grubtech.validator.InputDataValidator.validatePositionStr;

public class InputDataParserUtils {

    private static final String POSITION_DELIMITER = " ";

    private static final String DIMENSION_DELIMITER = " ";

    private static final String COMMAND_DELIMITER = "";

    private InputDataParserUtils() {
    }

    public static List<Rover> parseRovers(Iterator<String> iterator) {
        List<Rover> rovers = new ArrayList<>();
        LinkedList<CommandType> commands;
        List<String> position;
        while (iterator.hasNext()) {
            String positionStr = iterator.next();
            String commandStr;
            if (iterator.hasNext()) {
                commandStr = iterator.next();
            } else {
                throw new IllegalArgumentException(COMMAND_LINE_IS_MISSED);
            }

            validatePositionStr(positionStr);

            validateCommandStr(commandStr);

            position = Arrays.stream(positionStr.split(POSITION_DELIMITER))
                    .collect(Collectors.toList());

            commands = Arrays.stream(commandStr.split(COMMAND_DELIMITER))
                    .map(CommandType::valueOf)
                    .collect(Collectors.toCollection(LinkedList::new));

            Point point = new Point(Integer.parseInt(position.get(0)), Integer.parseInt(position.get(1)));
            DirectionType directionType = DirectionType.valueOf(position.get(2));
            rovers.add(new Rover(point, directionType, commands));
        }
        return rovers;
    }

    public static Grid parseGridDimension(Iterator<String> iterator) {
        Grid grid;
        List<Integer> gridDimension;

        if (iterator.hasNext()) {
            gridDimension = Arrays.stream(iterator.next().split(DIMENSION_DELIMITER)).
                    map(Integer::parseInt)
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException(UPPER_RIGHT_COORDINATES_ARE_MISSED);
        }

        if (gridDimension.size() == 2) {
            grid = new Grid(gridDimension.get(0), gridDimension.get(1));
        } else {
            throw new IllegalArgumentException(DIMENSION_UPPER_RIGHT_COORDINATES_ARE_INVALID);
        }
        return grid;
    }

}
