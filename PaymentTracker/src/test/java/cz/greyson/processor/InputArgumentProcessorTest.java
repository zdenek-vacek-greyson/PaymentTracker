package cz.greyson.processor;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Zdeněk Vacek on 14/03/2018
 */
public class InputArgumentProcessorTest {

    private InputArgumentProcessor inputArgumentProcessor;

    @Before
    public void init() {
        this.inputArgumentProcessor = new InputArgumentProcessor();
    }

    @Test
    public void processInputFileSuccessTest() {
        // expected results
        int expectedInputLinesSize = 5;
        List<String> expectedInputLines = Arrays.asList("USD 1000", "CZK 100", "USD -100", "CZK 2000", "CZK -200");

        // test execution
        File inputFile = new File("src/test/resources/valid_input_file_test.txt");
        List<String> inputLines = inputArgumentProcessor.processInputFile(inputFile);

        // result validation
        assertEquals(expectedInputLinesSize, inputLines.size());

        for (int i = 0; i < inputLines.size(); i++) {
            assertEquals(expectedInputLines.get(i), inputLines.get(i));
        }
    }

    @Test
    public void processNoInputDataTest() {
        // expected results

        // test execution
        List<String> processResults = inputArgumentProcessor.processInputFile(null);

        // result validation
        assertTrue(processResults.isEmpty());
    }

    @Test
    public void processNotExistingInputFileTest() {
        // expected results

        // test execution
        String[] args = new String[] {"blablabla.txt"};
        List<String> processResults = inputArgumentProcessor.processInputFile(null);

        // result validation
        assertTrue(processResults.isEmpty());
    }
}
