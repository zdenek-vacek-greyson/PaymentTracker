package cz.greyson.processor;

import com.google.common.base.Strings;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zdeněk Vacek on 13/03/2018
 */
public class InputArgumentProcessor {

    final static Logger logger = Logger.getLogger(InputArgumentProcessor.class);

    public List<String> process(String[] args) {
        List<String> inputLines = new ArrayList<>();

        if (args == null) {
            return inputLines;
        }

        if (args.length == 1) {
            String inputFileName = args[0];
            logger.debug("Trying to load input from file:" + inputFileName);
            File inputFile = new File(inputFileName);
            if (!inputFile.exists()) {
                logger.error("Error during parsing input file: \"" + inputFileName + "\". File not exists.");
                return inputLines;
            }

            inputLines = processInputFile(inputFile);
        }
        return inputLines;
    }

    public List<String> processInputFile(File inputFile) {
        List<String> inputLines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNext()) {
                String scannedLine = scanner.nextLine();
                if (Strings.isNullOrEmpty(scannedLine)) {
                    // skipping empty lines
                    continue;
                }
                inputLines.add(scannedLine);
            }
        } catch (FileNotFoundException e) {
            logger.error("Error during parsing input file: \"" + inputFile.getName() + "\"");
            e.printStackTrace();
        }
        return inputLines;
    }
}
