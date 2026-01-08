public class Appointment {
    private String appointmentId;
    private Patient patient;
    private double fee;

    public Appointment(String appointmentId, Patient patient, double fee) {
        setAppointmentId(appointmentId);
        this.patient = patient;
        setFee(fee);
    }

    public void setAppointmentId(String id) {
        this.appointmentId = (id == null || id.isEmpty()) ? "APP-000" : id;
    }

    public void setFee(double fee) {
        this.fee = (fee >= 0) ? fee : 0.0;
    }

    public double getFee() { return fee; }

    @Override
    public String toString() {
        return "Appointment [" + appointmentId + "] | Patient: " + patient.getName() + " | Fee: $" + fee;
    }
}