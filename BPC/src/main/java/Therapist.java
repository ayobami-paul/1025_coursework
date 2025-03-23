import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Therapist extends Member{
    private List<String> expertise;
    private List<Appointment> calendar;
    private Map<String, List<String>> expertiseTreatments;

    public Therapist(String firstName, String lastName){
        super(firstName, lastName);
        expertise = new ArrayList<String>();
        calendar = new ArrayList<>();
        initializeExpertiseTreatments();;
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

    public List<Appointment> getCalendarByExpertise(String expertise) {
        List<Appointment> filteredCalendar = new ArrayList<>();

        // Get the list of treatments for the given expertise
        List<String> treatmentsForExpertise = expertiseTreatments.get(expertise.toLowerCase());

        // If no treatments are found for the expertise, return an empty list
        if (treatmentsForExpertise == null || treatmentsForExpertise.isEmpty()) {
            System.out.println("No treatments found for expertise: " + expertise);
            return filteredCalendar;
        }

        // Filter the calendar to include only appointments with treatments for the given expertise
        for (Appointment appointment : calendar) {
            if (treatmentsForExpertise.contains(appointment.getTreatmentName())) {
                filteredCalendar.add(appointment);
            }
        }

        return filteredCalendar;
    }

    public void generateSchedule() {
        LocalDate startDate = LocalDate.now(); // Get current date
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("EEE"); // Formats to "Mon", "Tue", etc.
        Random random = new Random();
        List<String> allTreatments = getAllTreatments();
        if (allTreatments.isEmpty()) return;

        for (int week = 0; week < 4; week++) { // 4-week schedule
            for (int dayOffset = 0; dayOffset < 5; dayOffset++) { // Monday to Friday
                // Calculate the specific day
                LocalDate appointmentDate = startDate.with(DayOfWeek.MONDAY).plusWeeks(week).plusDays(dayOffset);
                String dayOfWeek = appointmentDate.format(dayFormatter); // e.g., "Mon", "Tue"

                LocalTime startTime = LocalTime.of(10, 0); // Start at 10 AM
                LocalTime endTime = LocalTime.of(17, 0);  // End at 4 PM

                while (startTime.isBefore(endTime)) {
                    String randomTreatment = allTreatments.get(random.nextInt(allTreatments.size()));

                    // Format slot time: "Week 1, Mon, 10:00"
                    String slotTime = "Week " + (week + 1) + ", " + dayOfWeek + ", " + startTime.format(DateTimeFormatter.ofPattern("HH:mm"));

                    // Create the appointment and add it to the therapist's calendar
                    Appointment therapistSchedule = new Appointment(this, randomTreatment, slotTime);
                    calendar.add(therapistSchedule);

                    startTime = startTime.plusHours(1); // Move to the next hour
                }
            }
        }
    }





    public String toString(){
        return "*********Physiotherapist Information*********" + super.toString();
    }
}
