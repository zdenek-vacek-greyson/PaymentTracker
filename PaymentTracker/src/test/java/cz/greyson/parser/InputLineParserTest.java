package cz.greyson.parser;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zdeněk Vacek on 14/03/2018
 */
public class InputLineParserTest {

    private InputLineParser inputLineParser;

    @Before
    public void init() {
        this.inputLineParser = new InputLineParser();
    }

    @Test
    public void parseLineSuccessTest() {
        // expected data
        Pair<String, String> expectedResultPair = new Pair<String, String>("USD", "1234");

        // method execution
        Pair<String, String> stringStringPair = inputLineParser.parseLine("USD 1234");

        // result validation
        assertEquals(expectedResultPair.getKey(), stringStringPair.getKey());
        assertEquals(expectedResultPair.getValue(), stringStringPair.getValue());
    }

    @Test
    public void parseLineFailedTest() {
        // expected data
        Pair<String, String> expectedResultPair = new Pair<String, String>("USD", "");

        // method execution
        Pair<String, String> stringStringPair = inputLineParser.parseLine("USD ");

        // result validation
        assertEquals(expectedResultPair.getKey(), stringStringPair.getKey());
        assertEquals(expectedResultPair.getValue(), stringStringPair.getValue());
    }

    @Test
    public void parseLineFailedTest2()  {
        // expected data
        Pair<String, String> expectedResultPair = new Pair<String, String>("USD", "dfdsa");

        // method execution
        Pair<String, String> stringStringPair = inputLineParser.parseLine("USD dfdsa");

        // result validation
        assertEquals(expectedResultPair.getKey(), stringStringPair.getKey());
        assertEquals(expectedResultPair.getValue(), stringStringPair.getValue());
    }
}
