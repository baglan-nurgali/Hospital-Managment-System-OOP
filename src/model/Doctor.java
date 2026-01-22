package model;

public class Doctor extends Person {
    private String specialization;

    public Doctor(int id, String name, int age, String specialization) {
        super(id, name, age);
        setSpecialization(specialization);
    }

    @Override
    public void performRole() {
        System.out.println("Doctor " + getName() + " [" + specialization + "] is working.");
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.isEmpty()) throw new IllegalArgumentException("Spec is empty");
        this.specialization = specialization;
    }
}