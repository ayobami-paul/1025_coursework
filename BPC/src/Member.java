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
        return id;
    }

    public void print(){
        System.out.println("\nID: " + id + "\nName: " + firstName + " " + lastName + "\nAddress: " + address + "\nPhone Number: " + phone);
    }

}
