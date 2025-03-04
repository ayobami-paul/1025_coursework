public class Main {
    public static void main(String[] args) {
        Therapist dew = new Therapist(1, "bob", "dylan");
        Patient pop = new Patient(1, "paul","chalamet");

        dew.addExpertise("massage");
        dew.addExpertise("acupuncture");

        System.out.println(dew.toString());
        System.out.println(pop.toString());
    }
}