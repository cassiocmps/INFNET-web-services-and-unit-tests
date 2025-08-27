public class AuditServiceSpy implements IAuditService {
    private boolean recordConsultationCalled = false;
    private Patient lastPatient;
    private double lastValue;

    @Override
    public void recordConsultation(Patient patient, double reimbursementValue) {
        recordConsultationCalled = true;
        lastPatient = patient;
        lastValue = reimbursementValue;
    }

    public boolean wasRecordConsultationCalled() {
        return recordConsultationCalled;
    }

    public Patient getLastPatient() {
        return lastPatient;
    }

    public double getLastValue() {
        return lastValue;
    }
}
