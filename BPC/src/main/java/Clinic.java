import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private ArrayList<Therapist> therapists;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> bookedAppointments;

    public Clinic() {
        therapists = new ArrayList<Therapist>();
        patients = new ArrayList<Patient>();
        bookedAppointments = new ArrayList<Appointment>();
        createClinic();
    }

    public void createClinic(){
        Therapist t1 = new Therapist("bob", "dylan");
        Therapist t2 = new Therapist("Emily", "Smith");

        t1.addExpertise("physiotherapy");
        t1.addExpertise("osteopathy");
        t2.addExpertise("osteopathy");

        addTherapist(t1);
        addTherapist(t2);
    }

    public void addTherapist(Therapist t) {
        if (!therapists.contains(t)) {
            therapists.add(t);
        } else {
            System.out.println("Therapist already exists");
        }
    }

    public void removeTherapist(Therapist t) {
        if (therapists.contains(t)) {
            therapists.remove(t);
        } else {
            System.out.println("Therapist not found");
        }
    }

    public List<Therapist> getTherapists() {
        return therapists;
    }

    public void addPatient(Patient p) {
        if (!patients.contains(p)) {
            patients.add(p);
        } else{
            System.out.println("Patient already exists");
        }
    }

    public void removePatient(Patient p) {
        if(patients.contains(p)) {
            patients.remove(p);
            System.out.println("Patient removed");
        } else {
            System.out.println("Patient not found");
        }
    }

    public Patient findPatientByName(String firstName, String lastName) {
        for (Patient p : patients) {
            if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) {
                return p;
            }
        }
        return null;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<List<Appointment>> getClinicCalendar(){
        List<List<Appointment>> clinicCalendar = new ArrayList<>();
        for (Therapist t : therapists) {
            clinicCalendar.add(t.getCalendar());
        }
        return clinicCalendar;
    }

    public String getClinicCalendar1(){
        String clinicCalendar1 = "";
        for (Therapist t : therapists) {
            clinicCalendar1 += t.getCalendar1();
        }
        return clinicCalendar1;
    }

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

    public void bookAppointment(Patient patient, String appointmentID){
        for (List<Appointment> appointments : getClinicCalendar()) {
            for (Appointment appointment : appointments) {
                if(appointment.getAppointmentId().equalsIgnoreCase(appointmentID)){
                    appointment.book(patient);
                    bookedAppointments.add(appointment);
                    System.out.println("Appointment booked");
                }
            }
        }
    }

    public List<Appointment> getBookedAppointments() {
        return bookedAppointments;
    }

    public void cancelAppointment(String appointmentID){
        for(Appointment appointment : bookedAppointments){
            if (appointment.getAppointmentId().equalsIgnoreCase(appointmentID) && appointment.getStatus().equalsIgnoreCase("Booked")){
                appointment.cancel();
                System.out.println("Appointment Cancelled");
            } else{
                System.out.println("Appointment not found");
            }
        }
    }

    public void attendAppointment(String appointmentID){
        for(Appointment appointment : bookedAppointments){
            if (appointment.getAppointmentId().equalsIgnoreCase(appointmentID) && appointment.getStatus().equalsIgnoreCase("Booked")){
                appointment.attend();
                System.out.println("Appointment Marked as attended");
            } else {
                System.out.println("Appointment not found");
            }
        }
    }

    public int getAttendedCount(Therapist therapist){
        int attendedCount = 0;
        for(Appointment appointment : bookedAppointments){
            if(appointment.getTherapist().equals(therapist) && appointment.getStatus().equalsIgnoreCase("Attended")){
                attendedCount++;
            }
        }
        return attendedCount;
    }


    public void getAllAppointments(){
        System.out.println("\n********All Appointments Report*********");
        for(Appointment appointment: bookedAppointments){
            System.out.println(appointment);
        }
    }

    public void getAppointmentReport(){
        // sort therapist in descending order by attended count
        therapists.sort((t1, t2) -> Integer.compare(getAttendedCount(t2), getAttendedCount(t1)));

        System.out.println("\n*************Report for All Attended Appointments*******************");

        for (Therapist therapist : therapists) {
            System.out.println("\n"+ therapist.getLastName() + " - Attended Appointments: " + getAttendedCount(therapist));

            for (Appointment appointment : bookedAppointments) {
                if (appointment.getTherapist().equals(therapist) && appointment.getStatus().equalsIgnoreCase("Attended")) {
                    System.out.println(appointment);
                }
            }

        }
    }

}
