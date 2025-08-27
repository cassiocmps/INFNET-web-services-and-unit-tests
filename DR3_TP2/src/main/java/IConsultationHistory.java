import java.util.List;

public interface IConsultationHistory {
    void addConsultation(double consultationValue);
    List<Double> getAllConsultations();
}
