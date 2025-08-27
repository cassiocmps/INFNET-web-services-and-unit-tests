import java.util.List;

public interface IConsultationHistory {
    void addConsultation(IPatient patient, double consultationValue);
    List<Double> getAllConsultations();
}
