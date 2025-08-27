import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReimbursementCalculatorTest {

    ReimbursementCalculator calculator;
    ConsultationHistoryFake history;
    PatientDummy patient;
    AuditServiceSpy auditSpy;

    @BeforeEach
    void setUp() {
        // Setup
        history = new ConsultationHistoryFake();
        auditSpy = new AuditServiceSpy();
        calculator = new ReimbursementCalculator(history, auditSpy);
        patient = new PatientDummy();
    }

    @Test
    void Calculate_With50PercentCoverage_ReturnsCorrectReimbursement() {
        // Arrange
        double consultationValue = 200.0;
        IHealthPlan plan = new HealthPlan50Stub();
        double expectedReimbursement = 100.0;

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, plan, patient);

        // Assert
        assertEquals(expectedReimbursement, actualReimbursement, 0.01);
    }

    @Test
    void Calculate_With80PercentCoverage_ReturnsCorrectReimbursement() {
        // Arrange
        double consultationValue = 200.0;
        IHealthPlan plan = new HealthPlan80Stub();
        double expectedReimbursement = 160.0;

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, plan, patient);

        // Assert
        assertEquals(expectedReimbursement, actualReimbursement, 0.01);
    }

    @Test
    void Calculate_ZeroConsultationValue_ReturnsZeroReimbursement() {
        // Arrange
        double consultationValue = 0.0;
        IHealthPlan plan = new HealthPlan50Stub();
        double expectedReimbursement = 0.0;

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, plan, patient);

        // Assert
        assertEquals(expectedReimbursement, actualReimbursement, 0.01);
    }

   @Test
   void Calculate_WhenCalled_CallsAudit() {
       // Arrange
       double consultationValue = 200.0;
       IHealthPlan plan = new HealthPlan50Stub();

       // Act
       calculator.calculate(consultationValue, plan, patient);

       // Assert
       assertTrue(auditSpy.wasRecordConsultationCalled());
   }
}