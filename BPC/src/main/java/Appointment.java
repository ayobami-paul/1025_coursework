import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Appointment {
    private Patient patient;
    private Therapist therapist;
//    private LocalDateTime time;
    private int time;
    private String day;
    private String status;
    private String bookingId;
    private String treatmentName;

    public Appointment(Therapist therapist, String treatmentName, String day) {
        this.therapist = therapist;
        this.status = "Available";
        this.treatmentName = treatmentName;
//        this.time = appointmentTime.getHour();
        this.day = day;
        this.bookingId = null;
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

    // this method seems redundant
    // i'm converting the treatments to individual strings instead of an array is why i'm leaving it for now
    public String getTreatmentsByTherapist() {
        String treatments = "";
        for(String treatment: this.therapist.getAllTreatments()){
            treatments +=  treatment + ", ";
        };
        return treatments;
    }

//    public LocalDateTime getAppointmentTime(){
//        return time;
//    }

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

    public String getTreatmentName() {
        return treatmentName;
    }

    public String toString() {
        if(status.equals("Available")){
            return "\n****************Available Appointment*******************" +
                    "\ntherapist: Dr " + therapist.getLastName() +
                    "\ntreatment: " + treatmentName  +
                    "\ntime: " + day +
                    "\nstatus: " + status ;
        }
        else if(status.equals("Booked")){
            return "****Your Appointment has been booked******" +
                    "\ntherapist: Dr" + therapist.getLastName() +
                    "patient:" + patient.getLastName() + patient.getFirstName() + '\'' +
                    "treatment: " + treatmentName + '\'' +
                    "\ntime: " + day +
                    "\nstatus: " + status + '\'' ;
        }
        else if(status.equals("Cancelled")){
            return "****Your Appointment has been cancelled******";
        }
        else if(status.equals("Attended")){
            return "****Your Appointment has been attended******";
        }
        else{
            return "***Appointment***";
        }
    }

}
