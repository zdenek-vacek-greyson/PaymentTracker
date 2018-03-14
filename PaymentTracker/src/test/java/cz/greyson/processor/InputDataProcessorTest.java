package cz.greyson.processor;

import cz.greyson.PaymentTrackerApplication;
import cz.greyson.exception.ValidatorException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Zdeněk Vacek on 14/03/2018
 */
public class InputDataProcessorTest {

    private InputDataProcessor inputDataProcessor;
    private PaymentTrackerApplication paymentTrackerApplication;

    @Before
    public void init() {
        this.paymentTrackerApplication = new PaymentTrackerApplication();
        this.inputDataProcessor = new InputDataProcessor(paymentTrackerApplication);
    }

    @Test
    public void processInputDataPairMultipleLineListTest() throws ValidatorException {
        // expected results
        String expectedKeyUSD = "USD";
        String expectedKeyCZK = "CZK";
        BigDecimal expectedValueUSD = new BigDecimal("2468");
        BigDecimal expectedValueCZK = new BigDecimal("123");
        int expectedSize = 2;

        // test execution
        List<String> inputLines = Arrays.asList("USD 1234", "CZK 123", "USD 1234");
        inputDataProcessor.processInputData(inputLines);

        // result validation
        assertTrue(paymentTrackerApplication.getInternalMemory().containsKey(expectedKeyUSD));
        assertTrue(paymentTrackerApplication.getInternalMemory().containsKey(expectedKeyCZK));
        assertEquals(expectedValueUSD, paymentTrackerApplication.getInternalMemory().get(expectedKeyUSD));
        assertEquals(expectedValueCZK, paymentTrackerApplication.getInternalMemory().get(expectedKeyCZK));
        assertEquals(expectedSize, paymentTrackerApplication.getInternalMemory().size());
    }

    @Test
    public void processInputDataTest() throws ValidatorException {
        // expected results
        String expectedKey = "USD";
        BigDecimal expectedValue = new BigDecimal("1234");
        int expectedSize = 1;

        // test execution
        inputDataProcessor.processInputData("USD 1234");

        // result validation
        assertTrue(paymentTrackerApplication.getInternalMemory().containsKey(expectedKey));
        assertEquals(expectedValue, paymentTrackerApplication.getInternalMemory().get(expectedKey));
        assertEquals(expectedSize, paymentTrackerApplication.getInternalMemory().size());
    }

    @Test
    public void processInputDataPairMultipleLineTest() throws ValidatorException {
        // expected results
        String expectedKeyUSD = "USD";
        String expectedKeyCZK = "CZK";
        BigDecimal expectedValueUSD = new BigDecimal("2468");
        BigDecimal expectedValueCZK = new BigDecimal("123");
        int expectedSize = 2;

        // test execution
        inputDataProcessor.processInputData("USD 1234");
        inputDataProcessor.processInputData("CZK 123");
        inputDataProcessor.processInputData("USD 1234");

        // result validation
        assertTrue(paymentTrackerApplication.getInternalMemory().containsKey(expectedKeyUSD));
        assertTrue(paymentTrackerApplication.getInternalMemory().containsKey(expectedKeyCZK));
        assertEquals(expectedValueUSD, paymentTrackerApplication.getInternalMemory().get(expectedKeyUSD));
        assertEquals(expectedValueCZK, paymentTrackerApplication.getInternalMemory().get(expectedKeyCZK));
        assertEquals(expectedSize, paymentTrackerApplication.getInternalMemory().size());
    }
}
