/**
 * Represents a patient in the healthcare system.
 * Inherits basic member information from the Member class.
 */
public class Patient extends Member{

    /**
     * Constructs a Patient with a given first and last name.
     *
     * @param firstName The patient's first name.
     * @param lastName  The patient's last name.
     */
    public Patient(String firstName, String lastName){
        super(firstName, lastName);
    }

    /**
     * Returns the unique identifier for the patient.
     *
     * @return The patient's ID.
     */
    public String getPatientId(){
        return super.getId();
    }

    /**
     * Returns a formatted string containing all patient details.
     *
     * @return Patient information as a formatted string.
     */
    public String getPatientDetail(){
        return "*********Patient Information*********" +
                "\nID: " + getPatientId() +
                "\nName: " + super.getFirstName() + " " + super.getLastName() +
                "\nAddress: " + super.getAddress() +
                "\nPhone Number: " + super.getPhone() +
                "\n";
    }
}
