import java.util.ArrayList;

public class Clinic {
    private ArrayList<Therapist> therapists;
    private ArrayList<Patient> patients;


    public Clinic(){
        therapists = new ArrayList<Therapist>();
        patients = new ArrayList<Patient>();
    }

    public void addPatient(Patient p){
        while(patients.size() < 10){
            patients.add(p);
            break;
        }
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
