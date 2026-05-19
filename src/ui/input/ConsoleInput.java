package ui.input;

import exception.InvalidInputException;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        while(true) {
            System.out.print(prompt);
            String s = scanner.nextLine();
            try {
                return Integer.parseInt(s.trim());
            } catch(NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public double readDouble(String prompt) {
        while(true) {
            System.out.print(prompt);
            String s = scanner.nextLine();
            try {
                return Double.parseDouble(s.trim());
            } catch(NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public <T extends Enum<T>> T readEnum(String prompt, Class<T> enumType) {
        while(true) {
            System.out.print(prompt);
            String s = scanner.nextLine();
            try {
                return Enum.valueOf(enumType, s.trim().toUpperCase());
            } catch(Exception e) {
                System.out.println("Invalid value. Allowed: " + String.join(", ", allowedValues(enumType)));
            }
        }
    }

    private static <T extends Enum<T>> String[] allowedValues(Class<T> enumType) {
        T[] values = enumType.getEnumConstants();
        String[] out = new String[values.length];
        for(int i = 0; i < values.length; i++) {
            out[i] = values[i].name();
        }
        return out;
    }

    public void requireNonBlank(String value, String message) {
        if(value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(message);
        }
    }
}
