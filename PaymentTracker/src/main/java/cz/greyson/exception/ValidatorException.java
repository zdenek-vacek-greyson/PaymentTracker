package cz.greyson.exception;

/**
 * Specific Exception for Validation Errors
 *
 * @author Zdeněk Vacek on 13/03/2018
 */
public class ValidatorException extends Exception {

    public ValidatorException(String message) {
        super(message);
    }
}
