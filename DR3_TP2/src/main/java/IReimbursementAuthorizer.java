public interface IReimbursementAuthorizer {
    boolean authorize(double consultationValue, IHealthPlan plan, IPatient patient);
}