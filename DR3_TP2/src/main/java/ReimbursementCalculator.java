public class ReimbursementCalculator {
    private ConsultationHistory consultationHistory;

    public ReimbursementCalculator(ConsultationHistory consultationHistory) {
        this.consultationHistory = consultationHistory;
    }

    public double calculate(double consultationValue, PlanoSaude plano, Patient patient) {
        consultationHistory.addConsultation(consultationValue);
        double coveragePercentage = plano.getCoveragePercentage();
        return consultationValue * coveragePercentage;
    }
}