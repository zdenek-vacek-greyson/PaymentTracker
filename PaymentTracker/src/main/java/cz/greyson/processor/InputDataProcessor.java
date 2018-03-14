package cz.greyson.processor;

import cz.greyson.PaymentTrackerApplication;
import cz.greyson.exception.ValidatorException;
import cz.greyson.parser.InputLineParser;
import cz.greyson.validator.ILineValidator;
import cz.greyson.validator.LineValidatorImpl;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Zdeněk Vacek on 14/03/2018
 */
public class InputDataProcessor {

    private PaymentTrackerApplication paymentTrackerApplication;
    private InputLineParser inputLineParser;
    private ILineValidator validator;

    public InputDataProcessor(PaymentTrackerApplication paymentTrackerApplication) {
        this.paymentTrackerApplication = paymentTrackerApplication;
        this.inputLineParser = new InputLineParser();
        this.validator = new LineValidatorImpl();
    }

    public void processInputData(List<String> inputLines) throws ValidatorException {
        for (String inputLine : inputLines) {
            processInputData(inputLine);
        }
    }

    public void processInputData(String inputLine) throws ValidatorException {
        Pair<String, String> inputPair = inputLineParser.parseLine(inputLine);
        Pair<String, BigDecimal> validInputPair = validator.isValid(inputPair);
        processInputData(validInputPair);
    }


    /**
     * Main calculation logic. Inserting new values into memory HashMap and appending existing values
     *
     * @param inputPair - new input values combination in Pair, key with value
     * */
    private void processInputData(Pair<String, BigDecimal> inputPair) {
        String key = inputPair.getKey();
        BigDecimal value = inputPair.getValue();
        if (!paymentTrackerApplication.getInternalMemory().containsKey(key)) {
            // insert new value
            paymentTrackerApplication.getInternalMemory().put(key, value);

        } else {
            // calculation new value
            BigDecimal oldValue = paymentTrackerApplication.getInternalMemory().get(key);
            BigDecimal newValue = oldValue.add(value);

            if (newValue.compareTo(BigDecimal.ZERO) != 0) {
                // append value
                paymentTrackerApplication.getInternalMemory().put(key, newValue);
            } else {
                // remove redundant ZERO row
                paymentTrackerApplication.getInternalMemory().remove(key);
            }
        }

    }
}
