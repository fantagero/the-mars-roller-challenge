package com.grubtech;

import com.grubtech.exception.InputFileReadException;
import com.grubtech.model.Grid;
import com.grubtech.model.Rover;
import com.grubtech.util.OutputDataUtils;
import com.grubtech.validator.InputDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.grubtech.command.handler.CommandHandlerFactory.createCommandHandler;
import static com.grubtech.util.InputDataParserUtils.parseGridDimension;
import static com.grubtech.util.InputDataParserUtils.parseRovers;

public class TheMarsRollerChallenge {

    private static Logger logger = LogManager.getLogger(TheMarsRollerChallenge.class);

    private static final String TEST_INPUTS_FILE_NAME = "/test_inputs.txt";

    private static final String TEST_OUTPUTS_FILE_NAME = "/expected_outputs.txt";

    public static void main(String... args) {
        List<String> inputLines = readFile(TEST_INPUTS_FILE_NAME);
        List<String> outputLines = readFile(TEST_OUTPUTS_FILE_NAME);

        logger.info("Test Inputs:");
        printLines(inputLines);

        logger.info("Expected Outputs:");
        printLines(outputLines);

        outputLines.forEach(InputDataValidator::validateOutputStr);

        Iterator<String> iterator = inputLines.iterator();
        Grid grid = parseGridDimension(iterator);
        List<Rover> rovers = parseRovers(iterator);

        List<String> result = handleCommands(grid, rovers);

        logger.info("Actual Outputs:");
        printLines(result);
    }

    private static void printLines(List<String> lines) {
        lines.forEach(logger::info);
    }

    private static List<String> handleCommands(Grid grid, List<Rover> rovers) {
        return rovers.stream()
                .map(r -> {
                    grid.setActivePoint(r.getPoint());
                    grid.setActiveDirection(r.getDirection());
                    return createCommandHandler(r.getCommands()).handle(grid);
                })
                .map(OutputDataUtils::formatOutput)
                .collect(Collectors.toList());
    }

    private static ArrayList<String> readFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        try (InputStreamReader fileReader = new InputStreamReader(
                TheMarsRollerChallenge.class.getResourceAsStream(fileName));
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String thisLine;
            while ((thisLine = bufferedReader.readLine()) != null) {
                lines.add(thisLine);
            }
        } catch (IOException | NullPointerException ex) {
            logger.error("Exception happened during file read with test data: {}", ex.getMessage());
            throw new InputFileReadException(ex);
        }
        return lines;
    }
}
