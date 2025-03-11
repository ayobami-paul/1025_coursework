public class Main {
    public static void main(String[] args) {
        Therapist t1 = new Therapist("bob", "dylan");
        Patient p1 = new Patient( "paul","Chalamet");
        Patient p2 = new Patient( "frank","Tome");

        t1.addExpertise("Physiotherapy");
        t1.addExpertise("Osteopathy");;

        Clinic c1 = new Clinic();
        c1.addPatient(p1);
        c1.addPatient(p2);

//        c1.removePatient(p1);

        c1.getAllPatients();
    }
}