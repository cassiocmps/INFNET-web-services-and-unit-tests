public class ReimbursementCalculator {
    private IConsultationHistory consultationHistory;
    private IAuditService audit;

    public ReimbursementCalculator(IConsultationHistory consultationHistory, IAuditService audit) {
        this.consultationHistory = consultationHistory;
        this.audit = audit;
    }

    public double calculate(double consultationValue, IHealthPlan plan, Patient patient) {
        double reimbursementValue = consultationValue * plan.getCoveragePercentage();
        consultationHistory.addConsultation(patient, consultationValue);
        audit.recordConsultation(patient, reimbursementValue);
        return reimbursementValue;
    }
}