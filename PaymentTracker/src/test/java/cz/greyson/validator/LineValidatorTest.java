package cz.greyson.validator;

import cz.greyson.exception.ValidatorException;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Zdeněk Vacek on 14/03/2018
 */
public class LineValidatorTest {
    private ILineValidator lineValidator;

    @Before
    public void init() {
        this.lineValidator = new LineValidatorImpl();
    }

    @Test
    public void isValidPairSuccessTest() throws ValidatorException {
        // expected results
        String expectedKey = "USD";
        BigDecimal expectedValue = new BigDecimal("1234");

        // test execution
        Pair<String, String> usd = new Pair<String, String>("USD", "1234");
        Pair<String, BigDecimal> valid = lineValidator.isValid(usd);

        // result validation
        Assert.assertEquals(expectedKey, valid.getKey());
        Assert.assertEquals(expectedValue, valid.getValue());
    }

    @Test(expected = NumberFormatException.class)
    public void isValidPairFailureTest() throws ValidatorException {
        // expected results
        String expectedKey = "USD";
        BigDecimal expectedValue = new BigDecimal("1234");

        // test execution
        Pair<String, String> usd = new Pair<String, String>("USD", "1a34");
        lineValidator.isValid(usd);
    }

    @Test(expected = ValidatorException.class)
    public void inputKeyValidationEmptyKeyTest() throws ValidatorException {
        lineValidator.inputKeyValidation(null);
    }

    @Test(expected = ValidatorException.class)
    public void inputKeyValidationWrongLengthTest() throws ValidatorException {
        lineValidator.inputKeyValidation("KC");
    }

    @Test
    public void inputValueValidationSuccessTest() {
        // expected results
        BigDecimal expectedValue = new BigDecimal("1234");

        // test execution
        BigDecimal result  = lineValidator.inputValueValidation("1234");

        // result validation
        Assert.assertEquals(expectedValue, result);
    }

    @Test(expected = NumberFormatException.class)
    public void inputValueValidationFailureTest() {
        // test execution
        lineValidator.inputValueValidation("1a34");
    }
}
