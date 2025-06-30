package com.cbfacademy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName(value = "ExceptionExercises Test Suite")
public class ExceptionExercisesTest {
    private ExceptionExercises exceptionExercises;

    @BeforeEach
    void setUp() {
        exceptionExercises = new ExceptionExercises();
    }

    // Tests for divide method
    @ParameterizedTest
    @DisplayName(value = "test the divide method returns the expected result for valid inputs")
    @CsvSource({
            "10.0, 2.0, 5.0",
            "15.0, 3.0, 5.0",
            "7.5, 2.5, 3.0",
            "100.0, 4.0, 25.0",
            "0.0, 5.0, 0.0"
    })
    void testDivideMethodReturnsExpectedResult(Double numerator, Double denominator, Double expectedResult) {
        Double result = exceptionExercises.divide(numerator, denominator);
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName(value = "test the divide method returns null when denominator is 0")
    void testDivideMethodReturnsNullForDivisionByZero() {
        Double result = exceptionExercises.divide(10.0, 0.0);
        assertNull(result);
    }

    @Test
    @DisplayName(value = "test the divide method returns null when either parameter is null")
    void testDivideMethodReturnsNullForNullParameters() {
        assertNull(exceptionExercises.divide(null, 5.0));
        assertNull(exceptionExercises.divide(10.0, null));
        assertNull(exceptionExercises.divide(null, null));
    }

    // Tests for getListElement method
    @Test
    @DisplayName(value = "test the getListElement method returns the element at the specified index")
    void testGetListElementReturnsCorrectElement() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        
        assertEquals(10, exceptionExercises.getListElement(numbers, 0));
        assertEquals(30, exceptionExercises.getListElement(numbers, 2));
        assertEquals(50, exceptionExercises.getListElement(numbers, 4));
    }

    @Test
    @DisplayName(value = "test the getListElement method returns -1 for out of bounds index")
    void testGetListElementReturnsMinusOneForOutOfBounds() {
        List<Integer> numbers = Arrays.asList(10, 20, 30);
        
        assertEquals(-1, exceptionExercises.getListElement(numbers, 5));
        assertEquals(-1, exceptionExercises.getListElement(numbers, -1));
        assertEquals(-1, exceptionExercises.getListElement(numbers, 10));
    }

    @Test
    @DisplayName(value = "test the getListElement method returns -1 when list is null")
    void testGetListElementReturnsMinusOneForNullList() {
        assertEquals(-1, exceptionExercises.getListElement(null, 0));
        assertEquals(-1, exceptionExercises.getListElement(null, 5));
    }

    @Test
    @DisplayName(value = "test the getListElement method works with empty list")
    void testGetListElementWithEmptyList() {
        List<Integer> emptyList = Collections.emptyList();
        assertEquals(-1, exceptionExercises.getListElement(emptyList, 0));
    }

    // Tests for convertToInteger method
    @ParameterizedTest
    @DisplayName(value = "test the convertToInteger method returns the expected integer for valid strings")
    @CsvSource({
            "123, 123",
            "0, 0",
            "-456, -456",
            "789, 789",
            "1, 1"
    })
    void testConvertToIntegerReturnsExpectedResult(String input, Integer expectedResult) {
        Integer result = exceptionExercises.convertToInteger(input);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @DisplayName(value = "test the convertToInteger method returns 0 for invalid strings")
    @CsvSource({
            "abc",
            "12.5",
            "hello",
            "123abc",
            "''",
            "' '"
    })
    void testConvertToIntegerReturnsZeroForInvalidStrings(String input) {
        Integer result = exceptionExercises.convertToInteger(input);
        assertEquals(0, result);
    }

    @Test
    @DisplayName(value = "test the convertToInteger method returns null when input is null")
    void testConvertToIntegerReturnsNullForNullInput() {
        assertNull(exceptionExercises.convertToInteger(null));
    }

    // Tests for getStringLength method
    @ParameterizedTest
    @DisplayName(value = "test the getStringLength method returns the expected formatted string")
    @CsvSource({
            "hello, 'Length: 5'",
            "Java, 'Length: 4'",
            "'', 'Length: 0'",
            "ExceptionHandling, 'Length: 17'",
            "a, 'Length: 1'"
    })
    void testGetStringLengthReturnsExpectedResult(String input, String expectedResult) {
        String result = exceptionExercises.getStringLength(input);
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName(value = "test the getStringLength method returns 'Length: 0' when input is null")
    void testGetStringLengthReturnsZeroLengthForNullInput() {
        String result = exceptionExercises.getStringLength(null);
        assertEquals("Length: 0", result);
    }

    // Tests for processData method
    @Test
    @DisplayName(value = "test the processData method returns the expected processed string for valid data")
    void testProcessDataReturnsExpectedResult() {
        List<String> data = Arrays.asList("123", "456", "789");
        
        assertEquals("Processed: 123", exceptionExercises.processData(data, 0));
        assertEquals("Processed: 456", exceptionExercises.processData(data, 1));
        assertEquals("Processed: 789", exceptionExercises.processData(data, 2));
    }

    @Test
    @DisplayName(value = "test the processData method returns 'Index out of bounds' for invalid index")
    void testProcessDataReturnsIndexOutOfBoundsMessage() {
        List<String> data = Arrays.asList("123", "456");
        
        assertEquals("Index out of bounds", exceptionExercises.processData(data, 5));
        assertEquals("Index out of bounds", exceptionExercises.processData(data, -1));
        assertEquals("Index out of bounds", exceptionExercises.processData(Collections.emptyList(), 0));
    }

    @Test
    @DisplayName(value = "test the processData method returns 'Invalid number format' for non-numeric strings")
    void testProcessDataReturnsInvalidNumberFormatMessage() {
        List<String> data = Arrays.asList("abc", "hello", "12.5");
        
        assertEquals("Invalid number format", exceptionExercises.processData(data, 0));
        assertEquals("Invalid number format", exceptionExercises.processData(data, 1));
        assertEquals("Invalid number format", exceptionExercises.processData(data, 2));
    }

    @Test
    @DisplayName(value = "test the processData method returns 'List is null' when data is null")
    void testProcessDataReturnsListIsNullMessage() {
        assertEquals("List is null", exceptionExercises.processData(null, 0));
        assertEquals("List is null", exceptionExercises.processData(null, 5));
    }

    @Test
    @DisplayName(value = "test the processData method handles mixed valid and invalid scenarios")
    void testProcessDataMixedScenarios() {
        List<String> mixedData = Arrays.asList("123", "abc", "456");
        
        assertEquals("Processed: 123", exceptionExercises.processData(mixedData, 0));
        assertEquals("Invalid number format", exceptionExercises.processData(mixedData, 1));
        assertEquals("Processed: 456", exceptionExercises.processData(mixedData, 2));
    }
} 