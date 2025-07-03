package com.cbfacademy;

import java.util.List;

/**
 * Exception handling exercises demonstrating proper exception handling techniques.
 * Each method handles specific exceptions gracefully and returns appropriate values.
 */
public class ExceptionExercises {

    /**
     * Performs division while handling potential arithmetic exceptions.
     * 
     * @param numerator   the numerator
     * @param denominator the denominator
     * @return the result of division, null if denominator is 0 or either parameter is null
     */
    public Integer divide(Integer numerator, Integer denominator) {
        if (numerator == null || denominator == null) {
            return null;
        }
        
        try {
            return numerator / denominator;
        } catch (ArithmeticException e) {
            return null;
        }
    }

    /**
     * Safely accesses list elements.
     * 
     * @param list  the list to access
     * @param index the index to retrieve
     * @return the element at the specified index, or -1 if index is out of bounds or list is null
     */
    public Integer getListElement(List<Integer> list, int index) {
        if (list == null) {
            return -1;
        }
        
        try {
            return list.get(index);
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    /**
     * Safely converts strings to integers.
     * 
     * @param numberString the string to convert
     * @return the integer value of the string, 0 if conversion fails, null if input is null
     */
    public Integer convertToInteger(String numberString) {
        if (numberString == null) {
            return null;
        }
        
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Safely processes strings to return their length.
     * 
     * @param input the input string
     * @return a formatted string with the length, "Length: 0" if input is null
     */
    public String getStringLength(String input) {
        try {
            return "Length: " + input.length();
        } catch (NullPointerException e) {
            return "Length: 0";
        }
    }

    /**
     * Demonstrates handling multiple types of exceptions.
     * Gets a string at the specified index from the list and converts it to an integer.
     * 
     * @param data  the list of strings
     * @param index the index to access
     * @return "Processed: [integer_value]", "Index out of bounds", "Invalid number format", or "List is null"
     */
    public String processData(List<String> data, int index) {
        if (data == null) {
            return "List is null";
        }
        
        try {
            String stringValue = data.get(index);
            try {
                Integer intValue = Integer.parseInt(stringValue);
                return "Processed: " + intValue;
            } catch (NumberFormatException e) {
                return "Invalid number format";
            }
        } catch (IndexOutOfBoundsException e) {
            return "Index out of bounds";
        }
    }
} 