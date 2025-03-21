import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {
    private Patient patient;
    private Therapist therapist;
    private int time;
    private Treatment treatment;
    private String status;
    private String bookingId;

    public Appointment(Therapist therapist) {
        this.therapist = therapist;
        this.status = "Available";
        this.time = LocalDateTime.now().getHour();
    }

    public Patient getPatient() {
        return patient;
    }

    public Therapist getTherapist() {
        return therapist;
    }

    public String getBookingId(){
        return bookingId;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public int getAppointmentTime(){
        return time;
    }

    public void book(Patient patient) {
        this.patient = patient;
        this.bookingId = UUID.randomUUID().toString();
        this.status = "Booked";
    }

    public void cancel(){
        this.patient = null;
        this.bookingId = null;
        this.status = "Cancelled";
    }

    public void attend() {
        this.status = "Attended";
    }

    public String getStatus() {
        return status;
    }

}
