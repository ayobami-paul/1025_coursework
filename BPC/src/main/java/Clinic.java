import java.util.ArrayList;
import java.util.List;

/**
 * Represents a clinic that manages therapists, patients, and appointments.
 * Provides functionality to book, cancel, and track appointments, as well as generate reports.
 */
public class Clinic {
    private ArrayList<Therapist> therapists;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> bookedAppointments;

    /**
     * Constructs a Clinic object and initializes its lists of therapists, patients, and appointments.
     * Also populates the clinic with sample data.
     */
    public Clinic() {
        therapists = new ArrayList<Therapist>();
        patients = new ArrayList<Patient>();
        bookedAppointments = new ArrayList<Appointment>();
        createClinic();
    }

    /**
     * Populates the clinic with sample therapists, patients, and their treatments.
     */
    public void createClinic(){
        Therapist t1 = new Therapist("bob", "dylan");
        Therapist t2 = new Therapist("Emily", "Smith");

        Patient p1 = new Patient("John", "Smith");

        t1.addExpertise("physiotherapy");
        t1.addExpertise("osteopathy");
        t2.addExpertise("osteopathy");

        addTherapist(t1);
        addTherapist(t2);
        addPatient(p1);
    }

    /**
     * Adds a therapist to the clinic if they are not already registered.
     *
     * @param t The therapist to add.
     */
    public void addTherapist(Therapist t) {
        if (!therapists.contains(t)) {
            therapists.add(t);
        } else {
            System.out.println("Therapist already exists");
        }
    }

    /**
     * Removes a therapist from the clinic if they are registered.
     *
     * @param t The therapist to remove.
     */
    public void removeTherapist(Therapist t) {
        if (therapists.contains(t)) {
            therapists.remove(t);
        } else {
            System.out.println("Therapist not found");
        }
    }

    /**
     * Gets the list of all therapists in the clinic.
     *
     * @return A list of Therapist objects.
     */
    public List<Therapist> getTherapists() {
        return therapists;
    }

    /**
     * Prints the details of all therapists in the clinic.
     */
    public void getAllTherapists() {
        System.out.println("\n****Clinic Therapist List****");
        for (Therapist therapist : therapists) {
            System.out.println(therapist.getTherapistDetails());
        }
    }

    /**
     * Adds a patient to the clinic if they are not already registered.
     *
     * @param p The patient to add.
     */
    public void addPatient(Patient p) {
        if (!patients.contains(p)) {
            patients.add(p);
        } else{
            System.out.println("Patient already exists");
        }
    }

    /**
     * Removes a patient from the clinic if they are registered.
     *
     * @param p The patient to remove.
     */
    public void removePatient(Patient p) {
        if(patients.contains(p)) {
            patients.remove(p);
            System.out.println("Patient removed");
        } else {
            System.out.println("Patient not found");
        }
    }

    /**
     * Finds a patient by their first and last name.
     *
     * @param firstName The first name of the patient.
     * @param lastName The last name of the patient.
     * @return The Patient object if found, or null if not found.
     */
    public Patient findPatientByName(String firstName, String lastName) {
        for (Patient p : patients) {
            if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) {
                return p;
            }
//            else{
//                System.out.println("Patient not found! Please register the patient first.");
//            }
        }
        return null;
    }

    /**
     * Gets the list of all patients in the clinic.
     *
     * @return A list of Patient objects.
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Prints the details of all patients in the clinic.
     */
    public void getAllPatients() {
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetail());
        }
    }

    /**
     * Gets the combined calendar of all therapists in the clinic.
     *
     * @return A list of lists, where each inner list represents a therapist's calendar.
     */
    public List<List<Appointment>> getClinicCalendar(){
        List<List<Appointment>> clinicCalendar = new ArrayList<>();
        for (Therapist t : therapists) {
            clinicCalendar.add(t.getCalendar());
        }
        return clinicCalendar;
    }

    /**
     * Gets a string representation of the combined calendar of all therapists.
     *
     * @return A formatted string with all appointments.
     */
    public String getClinicCalendar1(){
        String clinicCalendar1 = "";
        for (Therapist t : therapists) {
            clinicCalendar1 += t.getCalendar1();
        }
        return clinicCalendar1;
    }

    /**
     * Searches for a specific treatment expertise.
     *
     * @param expertise The expertise to search for (e.g., "physiotherapy").
     * @return boolean - true or false
     */
    public boolean searchExpertise(String expertise){
        for (Therapist therapist : therapists) {
            if (therapist.getExpertise().contains(expertise.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for available appointments by a specific treatment expertise.
     *
     * @param expertise The expertise to search for (e.g., "physiotherapy").
     */
    public void searchByExpertise(String expertise) {
        for (Therapist therapist : therapists) {
            if (therapist.getExpertise().contains(expertise.toLowerCase())) {
                for(Appointment appointment : therapist.getCalendarByExpertise(expertise)){
                    if(appointment.getStatus().equalsIgnoreCase("available")){
                        System.out.println(appointment);
                    }
                }
            }
        }
    }

    /**
     * Searches for a therapist's name.
     *
     * @param therapistName The first or last name of the therapist.
     * @return boolean - true or false
     */
    public boolean searchTherapistName(String therapistName){
        for (Therapist therapist : therapists) {
            if(therapist.getFirstName().equalsIgnoreCase(therapistName) || therapist.getLastName().equalsIgnoreCase(therapistName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for available appointments by a therapist's name.
     *
     * @param name The first or last name of the therapist.
     */
    public void searchByTherapist(String name) {
        for (Therapist therapist : therapists){
            if(therapist.getFirstName().equalsIgnoreCase(name) || therapist.getLastName().equalsIgnoreCase(name)) {
                for(Appointment appointment : therapist.getCalendar()){
                    if(appointment.getStatus().equalsIgnoreCase("available")){
                        System.out.println(appointment);
                    }
                }
            }
        }
    }


    /**
     * Books an appointment for a patient using the appointment ID.
     *
     * @param patient The patient to book the appointment for.
     * @param appointmentID The ID of the appointment to book.
     */
    public void bookAppointment(Patient patient, String appointmentID) {
        for (List<Appointment> appointments : getClinicCalendar()) {
            for (Appointment appointment : appointments) {
                if (appointment.getAppointmentId().equalsIgnoreCase(appointmentID)) {

                    // Check if patient already has a booking at the same time
                    for (Appointment booked : bookedAppointments) {
                        if (appointment.getTime().equals(booked.getTime()) && patient.equals(booked.getPatient())) {
                            System.out.println("Patient cannot book another appointment in the same time slot.");
                            return;
                        }
                    }

                    // Book the appointment
                    appointment.book(patient);
                    bookedAppointments.add(appointment);
                    System.out.println("Appointment booked successfully!");
                    return;
                }
            }
        }
    }


    /**
     * Gets the list of all booked appointments in the clinic.
     *
     * @return A list of Appointment objects.
     */
    public List<Appointment> getBookedAppointments() {
        return bookedAppointments;
    }

    /**
     * Cancels a booked appointment using the appointment ID.
     *
     * @param appointmentID The ID of the appointment to cancel.
     */
    public void cancelAppointment(String appointmentID){
        for(Appointment appointment : bookedAppointments){
            if (appointment.getAppointmentId().equalsIgnoreCase(appointmentID) && appointment.getStatus().equalsIgnoreCase("Booked")){
                appointment.cancel();
                System.out.println("Appointment Cancelled");
            }
//            else{
//                System.out.println("Appointment not found");
//            }
        }
    }

    /**
     * Marks a booked appointment as attended using the appointment ID.
     *
     * @param appointmentID The ID of the appointment to mark as attended.
     */
    public void attendAppointment(String appointmentID){
        for(Appointment appointment : bookedAppointments){
            if (appointment.getAppointmentId().equalsIgnoreCase(appointmentID) && appointment.getStatus().equalsIgnoreCase("Booked")){
                appointment.attend();
                System.out.println("Appointment Marked as attended");
            }
//            else {
//                System.out.println("Appointment not found");
//            }
        }
    }

    /**
     * Counts the number of attended appointments for a specific therapist.
     *
     * @param therapist The therapist to count attended appointments for.
     * @return The count of attended appointments.
     */
    public int getAttendedCount(Therapist therapist){
        int attendedCount = 0;
        for(Appointment appointment : bookedAppointments){
            if(appointment.getTherapist().equals(therapist) && appointment.getStatus().equalsIgnoreCase("Attended")){
                attendedCount++;
            }
        }
        return attendedCount;
    }

    /**
     * Prints a report of all booked appointments in the clinic.
     */
    public void getAppointmentReportByTherapist(String therapistName) {
        System.out.println("\n********Appointments Report*********");
        for (Appointment appointment : bookedAppointments) {
            Therapist therapist = appointment.getTherapist();
            if (therapist != null && (therapistName.equalsIgnoreCase(therapist.getFirstName()) || therapistName.equalsIgnoreCase(therapist.getLastName()))) {
                System.out.println(appointment);
            }
        }
    }


    /**
     * Generates and prints a report of all appointments, sorted by therapist and attended count.
     */
    public void getAppointmentReport(){
        // sort therapist in descending order by attended count
        therapists.sort((t1, t2) -> Integer.compare(getAttendedCount(t2), getAttendedCount(t1)));

        for (Therapist therapist : therapists) {
            System.out.println("\nDr "+ therapist.getLastName() + " - Attended Appointments: " + getAttendedCount(therapist));
            System.out.println("******Appointment Report*****");

            for (Appointment appointment : bookedAppointments) {
                if (appointment.getTherapist().equals(therapist) ) {
                    System.out.println(appointment);
                }
            }

        }
    }

}
