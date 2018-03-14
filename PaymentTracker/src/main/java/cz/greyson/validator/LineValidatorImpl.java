package cz.greyson.validator;

import com.google.common.base.Strings;
import cz.greyson.exception.ValidatorException;
import javafx.util.Pair;

import java.math.BigDecimal;

/**
 * @author Zdeněk Vacek on 13/03/2018
 */
public class LineValidatorImpl implements ILineValidator {

    public Pair<String, BigDecimal> isValid(Pair<String, String> inputPair) throws ValidatorException {
        return new Pair<String, BigDecimal>(inputKeyValidation(inputPair.getKey()), inputValueValidation(inputPair.getValue()));
    }

    public String inputKeyValidation(String inputKey) throws ValidatorException {

        if (Strings.isNullOrEmpty(inputKey)) {
            throw new ValidatorException("Invalid currency KEY: \"" + inputKey + "\"");
        }

        if (inputKey.length() != 3) {
            throw new ValidatorException("Currency KEY has wrong length: \"" + inputKey + "\"");
        }

        return inputKey;
    }

    public BigDecimal inputValueValidation(String inputValue) {
        return new BigDecimal(inputValue);
    }
}
