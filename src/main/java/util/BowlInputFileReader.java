package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlInputFileReader {
    private static BowlInputFileReader instance;

    private BowlInputFileReader() {
    }

    public static BowlInputFileReader getInstance() {
        if (instance == null) {
            instance = new BowlInputFileReader();
        }
        return instance;
    }

    public static List<List<Integer>> readDownPinsListFromFile(String filePath) {
        List<List<Integer>> downPinsList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                List<Integer> downPinsListOfEachLine = new ArrayList<>();
                String[] lineStrArray = scanner.nextLine().split(" ");
                for (String lineStr : lineStrArray) {
                    downPinsListOfEachLine.add(Integer.parseInt(lineStr));
                }
                downPinsList.add(downPinsListOfEachLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return downPinsList;
    }

    public static String outputDebug(List<List<Integer>> downPinsList) {
        StringBuilder outputStringBuilder = new StringBuilder();
        outputStringBuilder.append("==========\n");
        for (List<Integer> downPins: downPinsList) {
            for (int downPin: downPins) {
                outputStringBuilder.append(downPin);
                outputStringBuilder.append(' ');
            }
            outputStringBuilder.append('\n');
        }
        outputStringBuilder.append("==========\n");

        return outputStringBuilder.toString();
    }
}
