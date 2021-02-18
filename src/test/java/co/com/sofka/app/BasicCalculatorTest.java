package co.com.sofka.app;

import co.com.sofka.app.calculator.BasicCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sumar(number1, number2);

        // Assert
        Assertions.assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void severalSums(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.sumar(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several rests")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,    1,   -1",
            "10,    2,   8",
            "49,  51, -2",
            "100,  -100, 200"
    })
    void severalRests(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.restar(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several mults")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0,    1,   0",
            "0,    2,   0",
            "49,  51, 2499",
            "100,  -100, -10000"
    })
    void severalMults(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.multiplicar(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several divss")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0,    1,   0",
            "1,    0,   0",
            "-28,  -8, 3",
            "100,  -100, -1"
    })
    void severalDivs(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.dividir(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }
}
