import java.util.ArrayList;

public class Clinic {
    private ArrayList<Therapist> therapists;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;

    public Clinic() {
        therapists = new ArrayList<Therapist>();
        patients = new ArrayList<Patient>();
        appointments = new ArrayList<Appointment>();
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
            System.out.println(therapist.toString());
        }
    }

    public void searchByExpertise(String expertise) {
        for (Therapist therapist : therapists) {
            if (therapist.getExpertise().contains(expertise)) {
                //display all therapists names
                therapist.getFirstName();
                therapist.getLastName();

                //display all treatments
                therapist.getAllTreatments();
                //display schedule for those treatments

            }
        }
    }

    public void searchByTherapist(String name) {
        for (Therapist therapist : therapists){
            if(therapist.getFirstName().equals(name) || therapist.getLastName().equals(name)) {
                //display all treatments
                System.out.println(therapist.getTreatments());
//                System.out.println(therapist.getAllTreatments());

                //display schedule for those treatments
            }
        }
    }

    public void bookAppointment(Patient patient, Therapist therapist, String treatmentName){
        // initialize appointment
        Appointment appointment = new Appointment(patient, therapist, treatmentName);
        //book appointment
        appointment.book(patient);
        //add to list
        appointments.add(appointment);
    }


    public void cancelAppointment(Appointment app){
        for(Appointment appointment : appointments){
            if (appointment.equals(app)){
                app.cancel();
            }
        }
    }

    public void attendAppointment(Appointment app){
        for(Appointment appointment : appointments){
            if (appointment.equals(app)){
                app.attend();
            }
        }
    }


    public void getAllAppointments(){

    }
}
