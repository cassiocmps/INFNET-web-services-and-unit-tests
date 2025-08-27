import java.util.ArrayList;
import java.util.List;

public class FakeConsultationHistory implements IConsultationHistory {
    private List<Double> consultations;

    public FakeConsultationHistory() {
        this.consultations = new ArrayList<>();
    }

    @Override
    public void addConsultation(Patient patient, double consultationValue) {
        consultations.add(consultationValue);
    }

    @Override
    public List<Double> getAllConsultations() {
        return new ArrayList<>(consultations);
    }
}
