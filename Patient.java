public class Patient extends Person {
    private String diagnosis;

    public Patient(String name, int age, String diagnosis) throws InvalidDataException {
        super(name, age);
        this.diagnosis = diagnosis;
    }

    @Override
    public void performAction() {
        System.out.println("Patient " + name + " is taking prescribed medication.");
    }

    @Override
    public String getDetails() {
        return "[Patient] " + toString() + ", Diagnosis: " + diagnosis;
    }
}