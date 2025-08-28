import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReimbursementCalculatorTest {

    ReimbursementCalculator calculator;
    ConsultationHistoryFake history;
    PatientDummy patient;
    AuditServiceSpy auditSpy;
    IReimbursementAuthorizer authorizerMock;

    @BeforeEach
    void setUp() {
        // Setup
        history = new ConsultationHistoryFake();
        auditSpy = new AuditServiceSpy();
        authorizerMock = Mockito.mock(IReimbursementAuthorizer.class);
        calculator = new ReimbursementCalculator(history, auditSpy, authorizerMock);
        patient = new PatientDummy();
    }

    private Consultation createDefaultConsultation() {
        return new Consultation(200.0, new HealthPlan50Stub(), patient);
    }

    private void assertEqualsWithTolerance(double expected, double actual) {
        assertEquals(expected, actual, 0.01);
    }

    @Test
    void Calculate_With50PercentCoverage_ReturnsCorrectReimbursement() {
        // Arrange
        Consultation consultation = createDefaultConsultation();
        double expectedReimbursement = 100.0;
        Mockito.when(authorizerMock.authorize(consultation.getConsultationValue(), consultation.getPlan(), consultation.getPatient())).thenReturn(true);

        // Act
        double actualReimbursement = calculator.calculate(consultation.getConsultationValue(), consultation.getPlan(), consultation.getPatient());

        // Assert
        assertEqualsWithTolerance(expectedReimbursement, actualReimbursement);
    }

    @Test
    void Calculate_With80PercentCoverage_ReturnsCorrectReimbursement() {
        // Arrange
        double consultationValue = 100.0;
        IHealthPlan plan = new HealthPlan80Stub();
        double expectedReimbursement = 80.0;
        Mockito.when(authorizerMock.authorize(consultationValue, plan, patient)).thenReturn(true);

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, plan, patient);

        // Assert
        assertEqualsWithTolerance(expectedReimbursement, actualReimbursement);
    }

    @Test
    void Calculate_ZeroConsultationValue_ReturnsZeroReimbursement() {
        // Arrange
        double consultationValue = 0.0;
        IHealthPlan plan = new HealthPlan50Stub();
        double expectedReimbursement = 0.0;
        Mockito.when(authorizerMock.authorize(consultationValue, plan, patient)).thenReturn(true);

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, plan, patient);

        // Assert
        assertEqualsWithTolerance(expectedReimbursement, actualReimbursement);
    }

   @Test
   void Calculate_WhenCalled_CallsAudit() {
       // Arrange
       Consultation consultation = createDefaultConsultation();
       Mockito.when(authorizerMock.authorize(consultation.getConsultationValue(), consultation.getPlan(), consultation.getPatient())).thenReturn(true);

       // Act
       calculator.calculate(consultation.getConsultationValue(), consultation.getPlan(), consultation.getPatient());

       // Assert
       assertTrue(auditSpy.wasRecordConsultationCalled());
   }

    @Test
    void Calculate_WhenNotAuthorized_ThrowsException() {
        // Arrange
        Consultation consultation = createDefaultConsultation();
        Mockito.when(authorizerMock.authorize(consultation.getConsultationValue(), consultation.getPlan(), consultation.getPatient())).thenReturn(false);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(consultation.getConsultationValue(), consultation.getPlan(), consultation.getPatient());
        });
    }

    @Test
    void Calculate_ReimbursementExceedsMaximum_ReturnsMaximum() {
        // Arrange
        double consultationValue = 200.0;
        IHealthPlan plan = new HealthPlan80Stub();
        double expectedReimbursement = ReimbursementCalculator.MAX_REIMBURSEMENT_LIMIT;
        Mockito.when(authorizerMock.authorize(consultationValue, plan, patient)).thenReturn(true);

        // Act
        double actualReimbursement = calculator.calculate(consultationValue, plan, patient);

        // Assert
        assertEqualsWithTolerance(expectedReimbursement, actualReimbursement);
    }
}
    @Test
    void Calculate_WithStubMockAndFake_IntegratesAllComponentsCorrectly() {
        // Arrange
        IHealthPlan healthPlanStub = new HealthPlan80Stub();

        IReimbursementAuthorizer authorizerMock = Mockito.mock(IReimbursementAuthorizer.class);
        Mockito.when(authorizerMock.authorize(Mockito.anyDouble(), Mockito.any(IHealthPlan.class), Mockito.any(IPatient.class)))
                .thenReturn(true);

        ConsultationHistoryFake historyFake = new ConsultationHistoryFake();

        IPatient patientDummy = new PatientDummy();

        historyFake.addConsultation(patientDummy, 200.0);
        historyFake.addConsultation(patientDummy, 300.0);

        ReimbursementCalculator calculator = new ReimbursementCalculator(historyFake, authorizerMock, null);

        // Act
        double reimbursement = calculator.calculate(500.0, healthPlanStub, patientDummy);

        // Assert
        assertEqualsWithTolerance(400.0, reimbursement);

        Mockito.verify(authorizerMock).authorize(500.0, healthPlanStub, patientDummy);

        assertEquals(3, historyFake.getAllConsultations().size());
        assertTrue(historyFake.getAllConsultations().contains(500.0));
    }