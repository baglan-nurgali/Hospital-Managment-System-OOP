public class Patient extends Person {
    private String diagnosis;

    public Patient(String name, int age, String diagnosis) {
        super(name, age);
        setDiagnosis(diagnosis);
    }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.trim().isEmpty()) {
            this.diagnosis = "General Checkup";
        } else {
            this.diagnosis = diagnosis;
        }
    }

    @Override
    public void performAction() {
        System.out.println("Patient " + name + " is being examined for: " + diagnosis);
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Patient, Diagnosis: " + diagnosis;
    }
}