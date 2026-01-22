package model;

public class Patient extends Person implements Examinable {
    private String diagnosis;

    public Patient(int id, String name, int age, String diagnosis) {
        super(id, name, age);
        setDiagnosis(diagnosis);
    }

    @Override
    public void performRole() {
        System.out.println("Patient " + getName() + " is under observation.");
    }

    @Override
    public void undergoExamination() {
        System.out.println("Patient " + getName() + " is being examined for " + diagnosis);
    }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.isEmpty()) throw new IllegalArgumentException("Diagnosis is empty");
        this.diagnosis = diagnosis;
    }
}