import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Therapist t1 = new Therapist("bob", "dylan");
        Patient p1 = new Patient( "paul","Chalamet");
        Patient p2 = new Patient( "frank","Tome");
//        Appointment app1 = new Appointment(t1);

        t1.addExpertise("Physiotherapy");
        t1.addExpertise("Osteopathy");

        System.out.println(t1.getTherapistId());
        System.out.println(t1.getExpertise());
        System.out.println(t1.getTreatmentsForExpertise("physiotherapy"));
        System.out.println(t1.getAllTreatments());

//        System.out.println(app1.getTreatmentsByTherapist());

        Clinic c1 = new Clinic();
        c1.addPatient(p1);
        c1.addPatient(p2);

        c1.removePatient(p1);

//        c1.getAllPatients();
    }
}