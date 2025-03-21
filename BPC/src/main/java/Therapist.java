import java.util.ArrayList;
import java.util.List;

public class Therapist extends Member{
    private List<String> expertise;
    private List<Appointment> appointments;

    public Therapist(String firstName, String lastName){
        super(firstName, lastName);
        expertise = new ArrayList<String>();
        appointments = new ArrayList<>();
    }

    public Therapist(String firstName, String lastName, String address, String phone){
        super(firstName, lastName,address,phone);
        expertise = new ArrayList<String>();
    }

    public void getTherapistId(){
        super.getId();
    }

    public void addExpertise(String doctorExpertise) {
        expertise.add(doctorExpertise);
    }

    public List<String> getExpertise(){
        return expertise;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> getAppointments(){
        return appointments;
    }

    public String toString(){
        return "*********Physiotherapist Information*********" + super.toString();
    }
}
