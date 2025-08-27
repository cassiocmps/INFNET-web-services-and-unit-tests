public class AuditServiceSpy implements IAuditService {
    private boolean recordConsultationCalled = false;
    private IPatient lastPatient;
    private double lastValue;

    @Override
    public void recordConsultation(IPatient patient, double reimbursementValue) {
        recordConsultationCalled = true;
        lastPatient = patient;
        lastValue = reimbursementValue;
    }

    public boolean wasRecordConsultationCalled() {
        return recordConsultationCalled;
    }

    public IPatient getLastPatient() {
        return lastPatient;
    }

    public double getLastValue() {
        return lastValue;
    }
}
