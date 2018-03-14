package cz.greyson.validator;

import cz.greyson.exception.ValidatorException;
import javafx.util.Pair;

import java.math.BigDecimal;

/**
 * @author Zdeněk Vacek on 13/03/2018
 */
public interface ILineValidator {
    Pair<String, BigDecimal> isValid(Pair<String, String> inputPair) throws ValidatorException;
    String inputKeyValidation(String inputKey) throws ValidatorException;
    BigDecimal inputValueValidation(String inputValue);
}
