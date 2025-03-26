import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Clinic c1 = new Clinic();

        Patient p1 = new Patient( "paul","Chalamet");
        Patient p2 = new Patient( "frank","Tome");

//        c1.getAllTherapists();
//        c1.searchByExpertise("osteopathy");
//        c1.searchByTherapist("dylan");
//        c1.getClinicCalendar1();
        c1.bookAppointment(p1,"dylan-W1Mon-11");
//        c1.searchByTherapist("dylan");

    }
}