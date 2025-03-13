public class Treatment {
    private String expertise;
    private String treatmentName;

    public Treatment(String expertise, String treatmentName) {
        this.treatmentName  = treatmentName;
        this.expertise = expertise;
    }

    public String expertise() {
        return expertise;
    }

    public String treatmentName() {
        return treatmentName;
    }

    public String toString() {
        return "\nTreatment Name: " + treatmentName + "\n Expertise: " + expertise;
    }
}
