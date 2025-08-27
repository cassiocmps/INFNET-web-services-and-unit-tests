public class ReimbursementCalculator {
    private IConsultationHistory consultationHistory;
    private IAuditService audit;
    private IReimbursementAuthorizer authorizer;

    public static final double MAX_REIMBURSEMENT_LIMIT = 150.0;

    public ReimbursementCalculator(IConsultationHistory consultationHistory, IAuditService audit, IReimbursementAuthorizer authorizer) {
        this.consultationHistory = consultationHistory;
        this.audit = audit;
        this.authorizer = authorizer;
    }

    public double calculate(double consultationValue, IHealthPlan plan, IPatient patient) {
        if (!authorizer.authorize(consultationValue, plan, patient)) {
            throw new IllegalArgumentException("Reimbursement not authorized");
        }
        double reimbursementValue = consultationValue * plan.getCoveragePercentage();

        if (reimbursementValue > MAX_REIMBURSEMENT_LIMIT) {
            reimbursementValue = MAX_REIMBURSEMENT_LIMIT;
        }

        consultationHistory.addConsultation(patient, consultationValue);
        audit.recordConsultation(patient, reimbursementValue);
        return reimbursementValue;
    }
}