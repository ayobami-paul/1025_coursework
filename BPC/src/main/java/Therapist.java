import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Therapist extends Member{
    private List<String> expertise;
    private List<Appointment> calendar;
    private Map<String, List<String>> expertiseTreatments;

    public Therapist(String firstName, String lastName){
        super(firstName, lastName);
        expertise = new ArrayList<String>();
        calendar = new ArrayList<>();
        initializeExpertiseTreatments();
//        generateSchedule();
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
            // Clear the existing calendar to avoid duplicate appointments
            calendar.clear();
            // Regenerate the schedule with the updated expertise
            generateSchedule();
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

    public String getTreatments() {
        String allTreatments = "";
        for (String exp : expertise) {
            for(String treatment: expertiseTreatments.get(exp)){
                allTreatments +=  treatment + ", ";
            };
        }
        return allTreatments;
    }

    public String getTreatmentName(String name){
        String treatmentName = "";
        for (String exp : expertise) {
            for (String treatment : expertiseTreatments.get(exp)){
                if (treatment.equals(name)){
                    treatmentName = treatment;
                }
            };
        }
        return treatmentName;
    }


    public void addAppointment(Appointment appointment) {
        calendar.add(appointment);
    }

    public List<Appointment> getCalendar(){
        return calendar;
    }

    public void generateSchedule() {
        LocalTime startTime = LocalTime.of(10, 0); // Start at 10 AM
        LocalTime endTime = LocalTime.of(16, 0);  // End at 4 PM
        Random random = new Random();

        List<String> allTreatments = getAllTreatments();
        if (allTreatments.isEmpty()) return;

        while (startTime.isBefore(endTime)) {
            String randomTreatment = allTreatments.get(random.nextInt(allTreatments.size()));
            LocalDateTime slotTime = LocalDateTime.now().with(startTime);

            Appointment newAppointment = new Appointment(this, randomTreatment, slotTime);
            calendar.add(newAppointment); // Store in therapist's calendar

            startTime = startTime.plusHours(1); // Move to next hour
        }
    }



    public String toString(){
        return "*********Physiotherapist Information*********" + super.toString();
    }
}
