import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Clinic c1 = new Clinic();

        Therapist t1 = new Therapist("bob", "dylan");
        Therapist t2 = new Therapist("Emily", "Smith");

        Patient p1 = new Patient( "paul","Chalamet");
        Patient p2 = new Patient( "frank","Tome");

        t1.addExpertise("Physiotherapy");
        t1.addExpertise("Osteopathy");

        t2.addExpertise("Physiotherapy");

        System.out.println(t1.getCalendar());
    }
}