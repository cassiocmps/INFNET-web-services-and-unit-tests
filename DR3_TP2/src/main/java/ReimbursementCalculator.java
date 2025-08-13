public class ReimbursementCalculator {
    public double calculate(double consultationValue, double coveragePercentage) {
        return consultationValue * coveragePercentage;
    }
}