import java.util.ArrayList;

public class Clinic {
    private ArrayList<Therapist> therapists;
    private ArrayList<Patient> patients;


    public Clinic() {
        therapists = new ArrayList<Therapist>();
        patients = new ArrayList<Patient>();

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
        // accept treatment, physio name and time
        // if time and physio exists, add treatment, patient and status to appointment
        for (int i = 0; i < therapists.size(); i++) {
            Therapist therapist = therapists.get(i);
        }
    }

//    public void searchByExpertise(String name) {
//        for (int i = 0; i < therapists.size(); i++) {
//            Therapist therapist = therapists.get(i);
//        }
//    }




    public void getAllAppointments(){

    }
}
