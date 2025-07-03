# Exception Handling

[![Java Language](https://img.shields.io/badge/PLATFORM-OpenJDK-3A75B0.svg?style=for-the-badge)][1]
[![JUnit5 Testing Framework](https://img.shields.io/badge/testing%20framework-JUnit5-26A162.svg?style=for-the-badge)][2]
[![Maven Dependency Manager](https://img.shields.io/badge/dependency%20manager-Maven-AA215A.svg?style=for-the-badge)][3]

The goal of this exercise is to practise:
- Handling exceptions
- Creating custom exceptions

This project is organized into two modules that can be compiled and tested independently:

- **exception-handling**: Practical exception handling exercises
- **custom-exceptions**: Custom exception creation and file processing exercises

### Running Tests

To run all tests across both modules:

```shell
./mvnw clean test
```

To test a specific module:

```shell
./mvnw clean test -pl exception-handling
./mvnw clean test -pl custom-exceptions
```

## :pushpin: Exception Handling

Create a class called `ExceptionExercises` in the `exception-handling/src/main/java/com/cbfacademy` directory with the following methods that demonstrate proper exception handling techniques. Each method should handle specific exceptions gracefully and return appropriate values.

Using the [Java Exception Handling documentation][4] as a guide, implement the methods described below. In each method, replace `throw new RuntimeException("Not implemented")` with your code.

### Safe Division

Create a method that performs division while handling potential arithmetic exceptions:

```java
public Integer divide(Integer numerator, Integer denominator) {
    // TODO: Implement this method to divide the numerator by the denominator
    // - if either parameter is null, return null
    // - catch the ArithmeticException thrown when the denominator is 0 and return null
    // - return the result of the division
    throw new RuntimeException("Not implemented");
}
```

### Safe List Access

Create a method that safely accesses list elements:

```java
public Integer getListElement(List<Integer> list, int index) {
    // TODO: Implement this method to return the element at the specified index
    // - return the element at the given index
    // - if the index is out of bounds, catch IndexOutOfBoundsException and return -1
    // - if the list is null, return -1
    throw new RuntimeException("Not implemented");
}
```

### Safe String to Integer Conversion

Create a method that safely converts strings to integers:

```java
public Integer convertToInteger(String numberString) {
    // TODO: Implement this method to convert a string to an integer
    // - return the integer value of the string
    // - if the string cannot be converted, catch NumberFormatException and return 0
    // - if the string is null, return null
    throw new RuntimeException("Not implemented");
}
```

### Safe String Processing

Create a method that safely processes strings:

```java
public String getStringLength(String input) {
    // TODO: Implement this method to return a formatted string with the length
    // - return "Length: [length]" where [length] is the length of the input string
    // - if the input is null, catch NullPointerException and return "Length: 0"
    throw new RuntimeException("Not implemented");
}
```

### Multiple Exception Handling

Create a method that demonstrates handling multiple types of exceptions:

```java
public String processData(List<String> data, int index) {
    // TODO: Implement this method to process list data
    // - get the string at the specified index from the list
    // - convert that string to an integer
    // - return "Processed: [integer_value]"
    // - if index is out of bounds, return "Index out of bounds"
    // - if string conversion fails, return "Invalid number format"
    // - if the list is null, return "List is null"
    throw new RuntimeException("Not implemented");
}
```

**Example Usage:**
```java
ExceptionExercises exercises = new ExceptionExercises();

// Safe division
Integer result1 = exercises.divide(10, 2);    // Returns 5
Integer result2 = exercises.divide(10, 0);    // Returns null (handles ArithmeticException)

// Safe list access
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Integer element1 = exercises.getListElement(numbers, 2);    // Returns 3
Integer element2 = exercises.getListElement(numbers, 10);   // Returns -1 (handles IndexOutOfBoundsException)

// Safe string conversion
Integer num1 = exercises.convertToInteger("123");     // Returns 123
Integer num2 = exercises.convertToInteger("abc");     // Returns 0 (handles NumberFormatException)
```

#### :white_check_mark: Verify Your Implementation

To verify that your code works as expected, run the provided unit tests.

In your terminal, ensure that you are in the root directory of this repo, then run the following command:

```shell
./mvnw clean test -pl exception-handling
```

## :pushpin: Custom Exceptions

Create a custom (checked) exception class called `FilenameException` in the `custom-exceptions/src/main/java/com/cbfacademy` directory.

Create a class called `FileExtension` in the same directory with the following methods:

- `boolean check(String filename)`
- `Map<String, int> map(List<String> filenames)`

The `check` method should:
- return `true` when the file extension is `.java`
- return `false` when the file extension is not `.java`
- throw a `FilenameException` when the file name is `null` or an empty string.

The `map` method should:
- check each provided file's extension and map the returned value as 1 if true or 0 if false
- map `-1` when an exception occurs

**Example**

For the following list of file names: `Arrays.asList("App.java", "App.txt", null, "App.md")`, the `map` method should return a map with the following entries:

```txt
{"App.java", 1},
{"App.txt", 0},
{null, -1},
{"App.md", 0}
```

#### :white_check_mark: Verify Your Implementation

To verify that your code works as expected, run the provided unit tests.

In your terminal, ensure that you are in the root directory of this repo, then run the following command:

```shell
./mvnw clean test -pl custom-exceptions
```

Or to only run a specific test, use the `-Dtest=[test name]` flag, e.g.:

```shell
./mvnw clean test -pl custom-exceptions -Dtest=FileExtensionTest
```

Your implementation is correct when all tests pass.

#### :information_source: Notes
If you want to experiment with the provided application in the App.java file, you can run the following command from the terminal:

```shell
./mvnw -q clean compile exec:java
```

[1]: https://docs.oracle.com/javase/21/docs/api/index.html
[2]: https://junit.org/junit5/
[3]: https://maven.apache.org/
[4]: https://docs.oracle.com/javase/tutorial/essential/exceptions/