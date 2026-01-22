package model;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;

    public Appointment(Doctor doctor, Patient patient, String date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date: " + date + " | Doctor: " + doctor.getName() + " | Patient: " + patient.getName();
    }
}