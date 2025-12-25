public class Appointment {
    private String appointmentId;
    private String patientName;
    private String time;
    private double consultationFee;

    public Appointment(String appointmentId, String patientName, String time, double consultationFee) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.time = time;
        this.consultationFee = consultationFee;
    }

    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }

    public void applyUrgentSurcharge(double amount) {
        this.consultationFee += amount;
    }

    public boolean isEveningSession() {
        return time.contains("PM") || time.contains("18:") || time.contains("19:");
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + " | Patient: " + patientName + " | Time: " + time + " | Fee: " + consultationFee;
    }
}