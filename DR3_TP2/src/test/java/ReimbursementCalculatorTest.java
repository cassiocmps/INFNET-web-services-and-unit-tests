import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReimbursementCalculatorTest {

    ReimbursementCalculator calculator;

    @BeforeEach
    void setUp() {
        // Setup
        calculator = new ReimbursementCalculator();
    }

    @Test
    void Calculate_ConsultationValueAndCoverage_ReturnsCorrectReimbursement() {
        // Arrange
        double consultationValue = 200.0;
        double coveragePercentage = 0.70;
        double expectedReimbursement = 140.0;

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, coveragePercentage);

        // Assert
        assertEquals(expectedReimbursement, actualReimbursement, 0.01);
    }

    @Test
    void Calculate_ZeroConsultationValue_ReturnsZeroReimbursement() {
        // Arrange
        double consultationValue = 0.0;
        double coveragePercentage = 0.70;
        double expectedReimbursement = 0.0;

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, coveragePercentage);

        // Assert
        assertEquals(expectedReimbursement, actualReimbursement, 0.01);
    }

    @Test
    void Calculate_ZeroCoveragePercentage_ReturnsZeroReimbursement() {
        // Arrange
        double consultationValue = 200.0;
        double coveragePercentage = 0.0;
        double expectedReimbursement = 0.0;

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, coveragePercentage);

        // Assert
        assertEquals(expectedReimbursement, actualReimbursement, 0.01);
    }

    @Test
    void Calculate_FullCoveragePercentage_ReturnsFullConsultationValue() {
        // Arrange
        double consultationValue = 200.0;
        double coveragePercentage = 1.0; // 100%
        double expectedReimbursement = 200.0;

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, coveragePercentage);

        // Assert
        assertEquals(expectedReimbursement, actualReimbursement, 0.01);
    }
}
