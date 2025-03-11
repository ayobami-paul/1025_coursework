import java.util.ArrayList;

public class Therapist extends Member{
    private ArrayList<String> expertise;

    public Therapist(String firstName, String lastName){
        super(firstName, lastName);
        expertise = new ArrayList<String>();
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

    public String toString(){
        return "*********Physiotherapist Information*********" + super.toString();
    }
}
