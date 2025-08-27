

public class PatientDummy implements IPatient {
    @Override
    public String getName() {
        return "John Doe";
    }

    @Override
    public String getId() {
        return "12345";
    }
}
