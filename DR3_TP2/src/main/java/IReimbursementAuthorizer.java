public interface IReimbursementAuthorizer {
    boolean authorize(IPatient patient, double consultationValue);
}
