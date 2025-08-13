import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest {
    ScientificCalculator calc;

    @BeforeEach
    void setUp() {
        // Setup
        calc = new ScientificCalculator();
    }

    // ----------------------------------------------------------
    // Basic operations tests
    // ----------------------------------------------------------
    @Test
    void Addition_TwoPlusThree_EqualsFive() {
        // Execution
        double result = calc.add(2, 3);
        // Assertion
        assertEquals(5, result);
    }

    @Test
    void Subtract_FiveMinusThree_EqualsTwo() {
        // Execution
        double result = calc.subtract(5, 3);
        // Assertion
        assertEquals(2, result);
    }

    @Test
    void Divide_ByZero_ThrowsException() {
        // Execution and Assertion
        assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
    }

    // ----------------------------------------------------------
    // Square root tests
    // ----------------------------------------------------------
    
    @Test
    void SquareRoot_PositiveNumber_ReturnsRoot() {
        // Execution
        double result = calc.squareRoot(9);
        // Assertion
        assertEquals(3, result, 0.0001);
    }
    
    @Test
    void SquareRoot_NegativeNumber_ThrowsException() {
        // Execution and Assertion
        assertThrows(IllegalArgumentException.class, () -> calc.squareRoot(-1));
    }

    // ----------------------------------------------------------
    // Logarithm tests
    // ----------------------------------------------------------

    @Test
    void Log_NonPositive_ThrowsException() {
        // Execution and Assertion
        assertThrows(IllegalArgumentException.class, () -> calc.log(0));
    }

    @Test
    void Log_Ten_EqualsLogTenFromMathLib() {
        // Execution
        double result = calc.log(10);
        // Assertion
        assertEquals(Math.log(10), result, 0.0001);
    }

    // ----------------------------------------------------------
    // Trigonometric functions tests
    // ----------------------------------------------------------
    @Test
    void Sin_ZeroDegrees_EqualsZero() {
        // Execution
        double result = calc.sin(0);
        // Assertion
        assertEquals(0, result, 0.0001);
    }

    @Test
    void Sin_NinetyDegrees_EqualsOne() {
        // Execution
        double result = calc.sin(90);
        // Assertion
        assertEquals(1, result, 0.0001);
    }

    @Test
    void Cos_ZeroDegrees_EqualsOne() {
        // Execution
        double result = calc.cos(0);
        // Assertion
        assertEquals(1, result, 0.0001);
    }

    @Test
    void Cos_NinetyDegrees_EqualsZero() {
        // Execution
        double result = calc.cos(90);
        // Assertion
        assertEquals(0, result, 0.0001);
    }
}
