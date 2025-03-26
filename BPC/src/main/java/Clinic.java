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
        } else {
            System.out.println("Patient not found");
        }
    }

    public void getAllPatients() {
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            System.out.println(patient.toString());
        }
    }

    public void getAllTherapists() {
        for (int i = 0; i < therapists.size(); i++) {
            Therapist therapist = therapists.get(i);
            System.out.println(therapist.getTherapistDetails());
        }
    }

    public List<List<Appointment>> getClinicCalendar(){
        List<List<Appointment>> clinicCalendar = new ArrayList<List<Appointment>>();
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
//            System.out.println(therapist.getExpertise());
            if (therapist.getExpertise().contains(expertise.toLowerCase())) {
                System.out.println(therapist.getCalendarByExpertise(expertise));
            }
        }
    }

    public void searchByTherapist(String name) {
        for (Therapist therapist : therapists){
            if(therapist.getFirstName().equalsIgnoreCase(name) || therapist.getLastName().equalsIgnoreCase(name)) {
                //display all treatments
                System.out.println(therapist.getCalendar());
//                System.out.println(therapist.getAllTreatments());

                //display schedule for those treatments
            }
        }
    }

    public void bookAppointment(Patient patient, String appointmentID){
        for (List<Appointment> appointments : getClinicCalendar()) {
            for (Appointment appointment : appointments) {
                if(appointment.getAppointmentId().equalsIgnoreCase(appointmentID)){
                    System.out.println(appointment);
                    appointment.book(patient);
                    System.out.println(appointment);
                    bookedAppointments.add(appointment);
                }
            }
        }
    }


    public void cancelAppointment(String appointmentID){
        for(Appointment appointment : bookedAppointments){
            if (appointment.getAppointmentId().equalsIgnoreCase(appointmentID)){
                appointment.cancel();
            }
        }
    }

    public void attendAppointment(String appointmentID){
        for(Appointment appointment : bookedAppointments){
            if (appointment.getAppointmentId().equalsIgnoreCase(appointmentID)){
                appointment.attend();
            }
        }
    }


    public void getAllAppointments(){

    }
}
