import java.util.ArrayList;

public class Clinic {
    private ArrayList<Therapist> therapists;
    private ArrayList<Patient> patients;


    public Clinic(){
        therapists = new ArrayList<Therapist>();
        patients = new ArrayList<Patient>();
    }

    public void addTherapist(Therapist t){
        therapists.add(t);
    }

    public void removeTherapist(Therapist t){
        for(int i = 0; i < therapists.size(); i++){
            if (therapists.get(i).equals(t)){
                therapists.remove(i);
            }
        }
    }

    public void addPatient(Patient p){
            patients.add(p);
    }

    public void removePatient(Patient p){
        for(int i = 0; i < patients.size(); i++){
            if (patients.get(i).equals(p)){
                patients.remove(i);
            }
        }
    }

    public void getAllPatients(){
        for(int i = 0; i < patients.size(); i++){
            Patient patient = patients.get(i);
            System.out.println(patient.toString());
        }
    }
}
