import java.util.UUID;

public class Appointment {
    private Patient patient;
    private Therapist therapist;
    private String appointmentId;
    private String time;
    private String status;
    private String bookingId;
    private String treatmentName;

    public Appointment(String appointmentId, Therapist therapist, String treatmentName, String time) {
        this.appointmentId = appointmentId;
        this.therapist = therapist;
        this.status = "Available";
        this.treatmentName = treatmentName;
        this.time = time;
        this.bookingId = null;
    }

    public Patient getPatient() {
        return patient;
    }

    public Therapist getTherapist() {
        return therapist;
    }

    public String getAppointmentId() {
        return appointmentId;
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
        this.status = "Booked";
    }

    public void cancel(){
        this.patient = null;
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
            return "\n********Available Appointment********" +
                    "\nAppointmentID: " + appointmentId +
                    "\ntherapist: Dr " + therapist.getLastName() +
                    "\ntreatment: " + treatmentName  +
                    "\ntime: " + time +
                    "\nstatus: " + status ;
        }
        else {
            return "****Appointment****" +
                    "\nAppointmentID: " + appointmentId +
                    "\ntherapist: Dr " + therapist.getLastName() +
                    "\npatient: " + patient.getLastName() + " " + patient.getFirstName() +
                    "\ntreatment: " + treatmentName +
                    "\ntime: " + time +
                    "\nstatus: " + status ;
        }
    }
}
