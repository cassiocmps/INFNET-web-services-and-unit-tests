import java.util.List;

public interface IConsultationHistory {
    void addConsultation(Patient patient, double consultationValue);
    List<Double> getAllConsultations();
}
