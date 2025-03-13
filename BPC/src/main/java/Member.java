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

    public void getId() {
        System.out.println(id);
    }

    public String toString(){
        String place = (address == null) ? "None" : address;
        String number = (phone == null) ? "None" : phone;

        return "\nID: " + id +
                "\nName: " + firstName + " " + lastName +
                "\nAddress: " + place +
                "\nPhone Number: " + number +
                "\n";
    }

}
