public class Patient extends Member{

    public Patient(String firstName, String lastName){
        super(firstName, lastName);
    }

    public Patient(String firstName, String lastName, String address, String phone){
        super(firstName, lastName,address,phone);
    }

    public String getPatientId(){
        return super.getId();
    }

    public String toString(){
        return "*********Patient Information*********" + super.toString();
    }
}
