public class Patient extends Member{

    public Patient(String firstName, String lastName){
        super(firstName, lastName);
    }

    public String getPatientId(){
        return super.getId();
    }


    public String getPatientDetail(){
        return "*********Patient Information*********" +
                "\nID: " + getPatientId() +
                "\nName: " + super.getFirstName() + " " + super.getLastName() +
                "\nAddress: " + super.getAddress() +
                "\nPhone Number: " + super.getPhone() +
                "\n";
    }
}
