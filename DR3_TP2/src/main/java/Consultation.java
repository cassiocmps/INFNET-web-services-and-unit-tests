public class Consultation {
    private double consultationValue;
    private IHealthPlan plan;
    private IPatient patient;

    public Consultation(double consultationValue, IHealthPlan plan, IPatient patient) {
        this.consultationValue = consultationValue;
        this.plan = plan;
        this.patient = patient;
    }

    public double getConsultationValue() {
        return consultationValue;
    }

    public IHealthPlan getPlan() {
        return plan;
    }

    public IPatient getPatient() {
        return patient;
    }
}
