import java.util.UUID;

public class Member {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public Member(String firstName, String lastName){
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Member(String firstName, String lastName, String address, String phone){
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
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

    public String toString(){

        if(address == null && phone == null){
            return "\nID: " + id +
                    "\nName: " + firstName + " " + lastName;
        }

        String place = (address == null) ? "Not available" : address;
        String number = (phone == null) ? "Not available" : phone;

        return "\nID: " + id +
                "\nName: " + firstName + " " + lastName +
                "\nAddress: " + place +
                "\nPhone Number: " + number +
                "\n";
    }

}
