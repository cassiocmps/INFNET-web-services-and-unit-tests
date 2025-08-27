import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReimbursementCalculatorTest {

    ReimbursementCalculator calculator;
    FakeConsultationHistory history;
    Patient patient;

    @BeforeEach
    void setUp() {
        // Setup
        history = new FakeConsultationHistory();
        calculator = new ReimbursementCalculator(history);
        patient = new Patient();
    }

    @Test
    void Calculate_With50PercentCoverage_ReturnsCorrectReimbursement() {
        // Arrange
        double consultationValue = 200.0;
        PlanoSaude plano = new PlanoSaude50Stub();
        double expectedReimbursement = 100.0;

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, plano, patient);

        // Assert
        assertEquals(expectedReimbursement, actualReimbursement, 0.01);
    }

    @Test
    void Calculate_With80PercentCoverage_ReturnsCorrectReimbursement() {
        // Arrange
        double consultationValue = 200.0;
        PlanoSaude plano = new PlanoSaude80Stub();
        double expectedReimbursement = 160.0;

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, plano, patient);

        // Assert
        assertEquals(expectedReimbursement, actualReimbursement, 0.01);
    }

    @Test
    void Calculate_ZeroConsultationValue_ReturnsZeroReimbursement() {
        // Arrange
        double consultationValue = 0.0;
        PlanoSaude plano = new PlanoSaude50Stub();
        double expectedReimbursement = 0.0;

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, plano, patient);

        // Assert
        assertEquals(expectedReimbursement, actualReimbursement, 0.01);
    }
}