public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public Patient(int id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Patient(int id, String firstName, String lastName, String address, String phone){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public int getPatientId(){
        return id;
    }

    public String toString(){
        return "******Patient: \nID: " + id + "\nName: " + firstName + " " + lastName ;
    }
}
