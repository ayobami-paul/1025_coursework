import java.time.LocalDateTime;

public class Appointment {
    private Patient patient;
    private Therapist therapist;
    private LocalDateTime date;
    private Treatment treatment;
    private String status;

    public Appointment(Therapist therapist) {
        this.therapist = therapist;
        status = "Available";
    }

    public Patient getPatient() {
        return patient;
    }

    public Therapist getTherapist() {
        return therapist;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void book() {
        status = "Booked";
    }

    public void cancel(){
        status = "Cancelled";
    }

    public void attend() {
        status = "Attended";
    }

    public String getStatus() {
        return status;
    }

}
