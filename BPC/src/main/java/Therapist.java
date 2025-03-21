import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Therapist extends Member{
    private List<String> expertise;
    private List<Appointment> appointments;
    private Map<String, List<String>> expertiseTreatments;

    public Therapist(String firstName, String lastName){
        super(firstName, lastName);
        expertise = new ArrayList<String>();
        appointments = new ArrayList<>();
        initializeExpertiseTreatments();
    }

    public Therapist(String firstName, String lastName, String address, String phone){
        super(firstName, lastName,address,phone);
        expertise = new ArrayList<String>();
    }


    private void initializeExpertiseTreatments() {
        expertiseTreatments = new HashMap<>();

        // Physiotherapy treatments
        List<String> physiotherapyTreatments = new ArrayList<>();
        physiotherapyTreatments.add("mobilisation of the spine and joints");
        physiotherapyTreatments.add("massage");
        physiotherapyTreatments.add("exercise therapy");
        physiotherapyTreatments.add("electrotherapy");
        expertiseTreatments.put("physiotherapy", physiotherapyTreatments);

        // Osteopathy treatments
        List<String> osteopathyTreatments = new ArrayList<>();
        osteopathyTreatments.add("spinal manipulation");
        osteopathyTreatments.add("soft tissue techniques");
        osteopathyTreatments.add("cranial osteopathy");
        expertiseTreatments.put("osteopathy", osteopathyTreatments);

        // Rehabilitation treatments
        List<String> rehabilitationTreatments = new ArrayList<>();
        rehabilitationTreatments.add("pool rehabilitation");
        rehabilitationTreatments.add("gait training");
        rehabilitationTreatments.add("functional training");
        expertiseTreatments.put("rehabilitation", rehabilitationTreatments);

        // Neurological Physiotherapy treatments
        List<String> neurologicalPhysiotherapyTreatments = new ArrayList<>();
        neurologicalPhysiotherapyTreatments.add("neural mobilisation");
        neurologicalPhysiotherapyTreatments.add("coordination exercises");
        expertiseTreatments.put("neurological physiotherapy", neurologicalPhysiotherapyTreatments);
    }


    public String getTherapistId(){
        return super.getId();
    }


    public void addExpertise(String doctorExpertise) {
        if (expertiseTreatments.containsKey(doctorExpertise.toLowerCase())) {
            expertise.add(doctorExpertise.toLowerCase());
        } else {
            throw new IllegalArgumentException("Invalid expertise: " + doctorExpertise);
        }
    }

    public List<String> getExpertise(){
        return expertise;
    }

    public List<String> getTreatmentsForExpertise(String expertise) {
        return expertiseTreatments.get(expertise);
    }

    public List<String> getAllTreatments() {
        List<String> allTreatments = new ArrayList<>();
        for (String exp : expertise) {
            allTreatments.addAll(expertiseTreatments.get(exp));
        }
        return allTreatments;
    }


    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> getAppointments(){
        return appointments;
    }


    public String toString(){
        return "*********Physiotherapist Information*********" + super.toString();
    }
}
