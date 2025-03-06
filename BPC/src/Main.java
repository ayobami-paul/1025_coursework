public class Main {
    public static void main(String[] args) {
        Therapist dew = new Therapist("bob", "dylan");
        Patient pop = new Patient( "paul","chalamet");

        dew.addExpertise("Physiotherapy");
        dew.addExpertise("Osteopathy");

        String a = pop.getId();
        System.out.println(a);
    }
}