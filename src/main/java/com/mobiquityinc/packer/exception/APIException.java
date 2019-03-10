package com.mobiquityinc.packer.exception;

/**
 * Api exception model
 *
 * @author serkaneren
 */
public class APIException extends Exception {

    /**
     * public costructor
     * @param message exception message
     */
    public APIException(String message) {
        super(message);
    }
}
