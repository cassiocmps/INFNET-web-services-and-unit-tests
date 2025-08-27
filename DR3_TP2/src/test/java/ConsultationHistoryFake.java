import java.util.ArrayList;
import java.util.List;

public class ConsultationHistoryFake implements IConsultationHistory {
    private List<Double> consultations;

    public ConsultationHistoryFake() {
        this.consultations = new ArrayList<>();
    }

    @Override
    public void addConsultation(IPatient patient, double consultationValue) {
        consultations.add(consultationValue);
    }

    @Override
    public List<Double> getAllConsultations() {
        return new ArrayList<>(consultations);
    }
}
