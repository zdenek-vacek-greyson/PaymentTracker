package cz.greyson.parser;

import com.google.common.base.Splitter;
import cz.greyson.processor.InputArgumentProcessor;
import javafx.util.Pair;
import org.apache.log4j.Logger;

import java.util.Iterator;

/**
 * Parser for splitting input line into Pair Key and Value
 *
 * @author Zdeněk Vacek on 13/03/2018
 */
public class InputLineParser {

    final static Logger logger = Logger.getLogger(InputArgumentProcessor.class);

    private static final char SEPARATOR = ' ';

    /**
     * Parser for splitting input line into Pair Key and Value
     *
     * @param line - input line, f.e. "USD 1234"
     * @return parsed Pair Key and Value
     * */
    public Pair<String, String> parseLine(String line) {

        Iterable<String> lineParts = Splitter.on(SEPARATOR).split(line);

        String key = null;
        String value = null;
        Iterator<String> iterator = lineParts.iterator();

        if (iterator.hasNext()) {
            key = iterator.next();
            logger.debug("Parser currency KEY: " + key);
        }
        if (iterator.hasNext()) {
            value = iterator.next();
            logger.debug("Parser currency VALUE: " + value);
        }

        return new Pair<>(key, value);
    }
}

