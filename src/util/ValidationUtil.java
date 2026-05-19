package util;

import exception.InvalidInputException;

public final class ValidationUtil {
    private ValidationUtil() {}

    public static String requireNonBlank(String value, String fieldName) {
        if(value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " cannot be empty");
        }
        return value.trim();
    }

    public static int requireNonNegative(int value, String fieldName) {
        if(value < 0) {
            throw new InvalidInputException(fieldName + " cannot be negative");
        }
        return value;
    }

    public static double requireNonNegative(double value, String fieldName) {
        if(value < 0) {
            throw new InvalidInputException(fieldName + " cannot be negative");
        }
        return value;
    }
}
