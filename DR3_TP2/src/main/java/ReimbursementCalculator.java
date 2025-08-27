public class ReimbursementCalculator {
    private ConsultationHistory consultationHistory;

    public ReimbursementCalculator(ConsultationHistory consultationHistory) {
        this.consultationHistory = consultationHistory;
    }

    public double calculate(double consultationValue, double coveragePercentage, Patient patient) {
        consultationHistory.addConsultation(consultationValue);
        return consultationValue * coveragePercentage;
    }
}