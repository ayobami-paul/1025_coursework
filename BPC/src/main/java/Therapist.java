import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 * Represents a therapist in the healthcare system.
 * Includes management of expertise areas and an appointment calendar.
 * Generates a dynamic schedule based on assigned treatments.
 */
public class Therapist extends Member{
    private List<String> expertise;
    private List<Appointment> calendar;
    private Map<String, List<String>> expertiseTreatments;

    /**
     * Constructs a Therapist with the given first and last name.
     *
     * @param firstName The therapist's first name.
     * @param lastName  The therapist's last name.
     */
    public Therapist(String firstName, String lastName){
        super(firstName, lastName);
        expertise = new ArrayList<String>();
        calendar = new ArrayList<>();
        initializeExpertiseTreatments();
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


    /**
     * Assigns a new area of expertise to the therapist and regenerates their schedule.
     *
     * @param doctorExpertise A valid area of expertise (e.g., physiotherapy).
     * @throws IllegalArgumentException if the expertise is not recognized.
     */
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

    /**
     * Retrieves the list of all assigned expertise areas.
     *
     * @return A list of expertise categories.
     */
    public List<String> getExpertise(){
        return expertise;
    }

    /**
     * Gets treatments associated with a specific expertise.
     *
     * @param expertise The expertise category.
     * @return A list of treatments, or null if expertise is invalid.
     */
    public List<String> getTreatmentsForExpertise(String expertise) {
        return expertiseTreatments.get(expertise);
    }

    /**
     * Returns a combined list of all treatments based on assigned expertise.
     *
     * @return A list of treatments.
     */
    public List<String> getAllTreatments() {
        List<String> allTreatments = new ArrayList<>();
        for (String exp : expertise) {
            allTreatments.addAll(expertiseTreatments.get(exp));
        }
        return allTreatments;
    }

    /**
     * Returns a comma-separated string of all treatment names.
     *
     * @return All treatments as a single string.
     */
    public String getTreatments() {
        String allTreatments = "";
        for (String exp : expertise) {
            for(String treatment: expertiseTreatments.get(exp)){
                allTreatments +=  treatment + ", ";
            };
        }
        return allTreatments;
    }

    /**
     * Finds a specific treatment name from the therapist's expertise.
     *
     * @param name The name to look for.
     * @return The matched treatment name, or empty string if not found.
     */
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

    /**
     * Adds a specific appointment to the therapist's calendar.
     *
     * @param appointment The appointment to be added.
     */
    public void addAppointment(Appointment appointment) {
        calendar.add(appointment);
    }

    /**
     * Retrieves the full appointment calendar.
     *
     * @return List of appointments.
     */
    public List<Appointment> getCalendar(){
        return calendar;
    }

    public String getCalendar1(){
        return calendar.toString();
    }

    /**
     * Retrieves appointments filtered by a specific expertise.
     *
     * @param expertise The area of expertise.
     * @return Filtered list of relevant appointments.
     */
    public List<Appointment> getCalendarByExpertise(String expertise) {
        List<Appointment> filteredCalendar = new ArrayList<>();
//        String filteredCalendar = "";

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
//                filteredCalendar += appointment;
            }
        }

        return filteredCalendar;
    }

    /**
     * Generates a 4-week schedule of hourly appointments based on expertise treatments.
     */
    public void generateSchedule() {
        LocalDate startDate = LocalDate.now(); // Get current date
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("EEE"); // Formats to "Mon", "Tue", etc.
        Random random = new Random();
        List<String> allTreatments = getAllTreatments();
        if (allTreatments.isEmpty()) return;

        for (int week = 0; week < 3; week++) { // 4-week schedule
            for (int dayOffset = 0; dayOffset < 5; dayOffset++) { // Monday to Friday
                // Calculate the specific day
                LocalDate appointmentDate = startDate.with(DayOfWeek.MONDAY).plusWeeks(week).plusDays(dayOffset);
                String dayOfWeek = appointmentDate.format(dayFormatter); // e.g., "Mon", "Tue"

                LocalTime startTime = LocalTime.of(10, 0); // Start at 10 AM
                LocalTime endTime = LocalTime.of(15, 0);  // End at 2 PM

                while (startTime.isBefore(endTime)) {
                    String randomTreatment = allTreatments.get(random.nextInt(allTreatments.size()));

                    // Format slot time: "Week 1, Mon, 10:00"
                    String slotTime = "Week " + (week + 1) + ", " + dayOfWeek + ", " + startTime.format(DateTimeFormatter.ofPattern("HH:mm"));
                    String apptId = this.getLastName() + "-W"+ (week+1) + dayOfWeek + "-" + startTime.getHour();

                    // Create the appointment and add it to the therapist's calendar
                    Appointment therapistSchedule = new Appointment(apptId,this, randomTreatment, slotTime);
                    calendar.add(therapistSchedule);

                    startTime = startTime.plusHours(1); // Move to the next hour
                }
            }
        }
    }

    /**
     * Returns formatted therapist details including name and expertise.
     *
     * @return Therapist details as a string.
     */
    public String getTherapistDetails(){
        return "*********Physiotherapist Information*********"  +
                "\nID: " + getTherapistId() +
                "\nName: " + super.getFirstName() + " " + super.getLastName() +
                "\nExpertise: " + getExpertise() +
                "\n";
    }
}
