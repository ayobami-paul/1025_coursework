import java.util.UUID;

/**
 * Abstract class representing a member of the system.
 * Contains basic personal details like name, address, and phone number.
 * Serves as a base for more specific member types such as Patient or Therapist.
 */
public abstract class Member {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    public static String notAvailable = "Not available";

    public Member(String firstName, String lastName){
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = notAvailable;
        this.phone = notAvailable;
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void addAddress(String address){
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void addPhone(String phone){
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

}
