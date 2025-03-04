import java.util.ArrayList;

public class Therapist {
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<String> expertise;

    public Therapist(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        expertise = new ArrayList<String>();
    }

    public void addExpertise(String treatmentExpertise) {
        expertise.add(treatmentExpertise);
    }

    public void getTherapist(int id){
//        return id;
    }

    public void getByExpertise(String expertise){

    }

    public String toString(){
        return "******Therapist: \nID: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName +"\nExpertise: " + expertise;
    }
}
