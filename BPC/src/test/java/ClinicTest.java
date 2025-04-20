
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicTest {
    private Clinic clinic;
    private Therapist therapist;
    private Patient patient;
    private Appointment appointment;

    @BeforeEach
    public void setUp() {
        clinic = new Clinic();

        therapist = new Therapist("Jonathan", "Devoe");
        therapist.addExpertise("physiotherapy");

        patient = new Patient("Clark", "Kent");

        clinic.addTherapist(therapist);
        clinic.addPatient(patient);
    }

    @org.junit.jupiter.api.Test
    void testAddTherapist() {
        Therapist newTherapist = new Therapist("New", "Therapist");
        newTherapist.addExpertise("osteopathy");

        clinic.addTherapist(newTherapist);
        assertEquals(4, clinic.getTherapists().size());
        assertTrue(clinic.getTherapists().contains(newTherapist));
    }

    @org.junit.jupiter.api.Test
    void testRemoveTherapist() {
        clinic.removeTherapist(therapist);
        assertFalse(clinic.getTherapists().contains(therapist));
    }

    @org.junit.jupiter.api.Test
    void testAddPatient() {
        Patient p2 = new Patient("Alice", "Brown");
        clinic.addPatient(p2);
        assertEquals(2, clinic.getPatients().size());
    }

    @org.junit.jupiter.api.Test
    void testRemovePatient() {
        clinic.removePatient(patient);
        assertFalse(clinic.getPatients().contains(patient));
    }

    @org.junit.jupiter.api.Test
    void testFindPatientByName() {
        // Test existing patient
        Patient found = clinic.findPatientByName("John", "Doe");
        assertNotNull(found);
        assertEquals("John", found.getFirstName());
        assertEquals("Doe", found.getLastName());

        // Test non-existent patient
        assertNull(clinic.findPatientByName("Nonexistent", "Patient"));
    }

    @org.junit.jupiter.api.Test
    void testGetPatients(){
        int expected = 1;
        int patientsSize = clinic.getPatients().size();
        assertEquals(expected, patientsSize);
    }

    @org.junit.jupiter.api.Test
    void testSearchByExpertise() {
        // Should find appointments for both therapists (both have osteopathy)
        assertDoesNotThrow(() -> clinic.searchByExpertise("osteopathy"));

        // Should find appointments only for therapist1
        assertDoesNotThrow(() -> clinic.searchByExpertise("physiotherapy"));

        // Should find no appointments
        assertDoesNotThrow(() -> clinic.searchByExpertise("nonexistent"));
    }

    @org.junit.jupiter.api.Test
    void testSearchByTherapist() {
        // Test search by first name
        assertDoesNotThrow(() -> clinic.searchByTherapist("bob"));

        // Test search by last name
        assertDoesNotThrow(() -> clinic.searchByTherapist("dylan"));

        // Test non-existent therapist
        assertDoesNotThrow(() -> clinic.searchByTherapist("nonexistent"));
    }

    @org.junit.jupiter.api.Test
    void testBookAppointment() {
        // Get an available appointment
        List<List<Appointment>> calendar = clinic.getClinicCalendar();
        Appointment availableAppointment = null;
        for (List<Appointment> therapistAppointments : calendar) {
            for (Appointment appointment : therapistAppointments) {
                if (appointment.getStatus().equalsIgnoreCase("available")) {
                    availableAppointment = appointment;
                    break;
                }
            }
            if (availableAppointment != null) break;
        }

        assertNotNull(availableAppointment, "No available appointments found for testing");

        // Book the appointment
        clinic.bookAppointment(patient, availableAppointment.getAppointmentId());
        assertEquals("Booked", availableAppointment.getStatus());
        assertEquals(patient, availableAppointment.getPatient());
        assertEquals(1, clinic.getBookedAppointments().size());

    }

    @org.junit.jupiter.api.Test
    void testCancelAppointment() {
        // First book an appointment
        testBookAppointment(); // reuse the booking test
        Appointment bookedAppointment = clinic.getBookedAppointments().get(0);

        // Cancel the appointment
        clinic.cancelAppointment(bookedAppointment.getAppointmentId());
        assertEquals("Available", bookedAppointment.getStatus());
        assertNull(bookedAppointment.getPatient());

        // Try to cancel non-existent appointment
        assertDoesNotThrow(() -> clinic.cancelAppointment("nonexistent-id"));
    }

    @org.junit.jupiter.api.Test
    void testAttendAppointment() {
        // First book an appointment
        testBookAppointment(); // reuse the booking test
        Appointment bookedAppointment = clinic.getBookedAppointments().get(0);

        // Attend the appointment
        clinic.attendAppointment(bookedAppointment.getAppointmentId());
        assertEquals("Attended", bookedAppointment.getStatus());

        // Try to attend non-existent appointment
        assertDoesNotThrow(() -> clinic.attendAppointment("nonexistent-id"));
    }

    @org.junit.jupiter.api.Test
    void testGetAttendedCount() {
        // Book and attend two appointments with therapist1
        List<Appointment> therapist1Appointments = therapist.getCalendar();
        Appointment app1 = therapist1Appointments.get(0);
        Appointment app2 = therapist1Appointments.get(1);

        clinic.bookAppointment(patient, app1.getAppointmentId());
        clinic.attendAppointment(app1.getAppointmentId());

        clinic.bookAppointment(patient, app2.getAppointmentId());
        clinic.attendAppointment(app2.getAppointmentId());

        assertEquals(2, clinic.getAttendedCount(therapist));
    }

    @org.junit.jupiter.api.Test
    void testGetAppointmentReport() {
        // Book and attend some appointments
        List<Appointment> therapist1Appointments = therapist.getCalendar();
        String app1Id = therapist1Appointments.get(0).getAppointmentId();
        List<Appointment> therapist2Appointments = clinic.getTherapists().get(0).getCalendar();
        String app2Id = therapist2Appointments.get(0).getAppointmentId();

        clinic.bookAppointment(patient, app1Id);
        clinic.attendAppointment(app1Id);

        clinic.bookAppointment(patient, app2Id);
        clinic.attendAppointment(app2Id);

        clinic.bookAppointment(patient, app1Id);
        clinic.attendAppointment(app1Id);

        // Test the report output
        assertDoesNotThrow(() -> clinic.getAppointmentReport());
    }
}