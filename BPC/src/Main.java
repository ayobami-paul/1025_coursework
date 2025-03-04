public class Main {
    public static void main(String[] args) {
        Therapist dew = new Therapist(1, "bob", "dylan");

        dew.addExpertise("massage");

        System.out.println(dew.toString());
    }
}