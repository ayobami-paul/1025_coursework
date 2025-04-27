import java.util.UUID;

/**
 * Represents an appointment in a clinic, linking a patient with a therapist for a specific treatment at a scheduled time.
 * The appointment can be in different states: Available, Booked, Cancelled, or Attended.
 */
public class Appointment {
    private Patient patient;
    private Therapist therapist;
    private String appointmentId;
    private String time;
    private String status;
    private String bookingId;
    private String treatmentName;

    /**
     * Constructs an Appointment object with the specified details.
     *
     * @param appointmentId The unique identifier for the appointment.
     * @param therapist The therapist assigned to the appointment.
     * @param treatmentName The name of the treatment for the appointment.
     * @param time The scheduled time of the appointment.
     */
    public Appointment(String appointmentId, Therapist therapist, String treatmentName, String time) {
        this.appointmentId = appointmentId;
        this.therapist = therapist;
        this.status = "Available";
        this.treatmentName = treatmentName;
        this.time = time;
        this.bookingId = null;
    }

    /**
     * Gets the patient associated with the appointment.
     *
     * @return The Patient object, or null if no patient is booked.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Gets the therapist associated with the appointment.
     *
     * @return The Therapist object.
     */
    public Therapist getTherapist() {
        return therapist;
    }

    /**
     * Gets the unique identifier of the appointment.
     *
     * @return The appointment ID.
     */
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     * Gets a comma-separated string of all treatments offered by the therapist.
     *
     * @return A string listing all treatments.
     */
    public String getTreatmentsByTherapist() {
        String treatments = "";
        for(String treatment: this.therapist.getAllTreatments()){
            treatments +=  treatment + ", ";
        };
        return treatments;
    }

    /**
     * Books the appointment for a specific patient and updates the status to "Booked".
     *
     * @param patient The patient to book the appointment for.
     */
    public void book(Patient patient) {
        this.patient = patient;
        this.status = "Booked";
    }

    /**
     * Cancels the appointment, removes the patient, and updates the status to "Cancelled".
     */
    public void cancel(){
        this.status = "Cancelled";
    }

    /**
     * Marks the appointment as attended and updates the status to "Attended".
     */
    public void attend() {
        this.status = "Attended";
    }

    /**
     * Gets the current status of the appointment.
     *
     * @return The status of the appointment (e.g., "Available", "Booked", "Cancelled", "Attended").
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the time of the appointment.
     *
     * @return The time of the appointment (e.g., "Week1, Tue, 12:00").
     */
    public String getTime(){
        return time;
    }

    /**
     * Gets the name of the treatment associated with the appointment.
     *
     * @return The treatment name.
     */
    public String getTreatmentName() {
        return treatmentName;
    }

    /**
     * Returns a string representation of the appointment, including its details.
     * The format varies depending on whether the appointment is available or booked.
     *
     * @return A formatted string with appointment details.
     */
    public String toString() {
        if(status.equalsIgnoreCase("Available")){
            return "\n********Available Appointment********" +
                    "\nAppointmentID: " + appointmentId +
                    " | therapist: Dr " + therapist.getLastName() +
                    " | treatment: " + treatmentName  +
                    " | time: " + time +
                    " | status: " + status ;
        }
        else {
            return "****Appointment****" +
                    "\nAppointmentID: " + appointmentId +
                    " | therapist: Dr " + therapist.getLastName() +
                    " | patient: " + patient.getLastName() + " " + patient.getFirstName() +
                    " | treatment: " + treatmentName +
                    " | time: " + time +
                    " | status: " + status ;
        }
    }
}
