package cz.greyson.validator;

import cz.greyson.exception.ValidatorException;
import javafx.util.Pair;

import java.math.BigDecimal;

/**
 * Input Line Validator Interface
 *
 * @author Zdeněk Vacek on 13/03/2018
 */
public interface ILineValidator {

    /**
     * Validation input data (generic test in Pair<String, String> and their conversion into final Data Types
     * @param inputPair - parsed input data
     * @return - validated and converted input data
     * @throws ValidatorException - specific error during validation
     * */
    Pair<String, BigDecimal> isValid(Pair<String, String> inputPair) throws ValidatorException;

    /**
     * Validation input KEY data
     * @param inputKey - parsed input KEY data
     * @return - validated and converted input KEY data
     * @throws ValidatorException - specific error during validation
     * */
    String inputKeyValidation(String inputKey) throws ValidatorException;

    /**
     * Validation input VALUE data
     * @param inputValue - parsed input VALUE data
     * @return - validated and converted input VALUE data
     * @throws ValidatorException - specific error during validation
     * */
    BigDecimal inputValueValidation(String inputValue);
}
