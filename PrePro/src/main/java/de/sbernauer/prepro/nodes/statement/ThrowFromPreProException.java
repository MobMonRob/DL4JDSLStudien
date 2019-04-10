package de.sbernauer.prepro.nodes.statement;

/**
 * This exception is thrown, when the "throw"-Statement is used in the PrePro-Sourcecode.
 */
public class ThrowFromPreProException extends RuntimeException {

    public ThrowFromPreProException(String message) {
        super(message);
    }
}
