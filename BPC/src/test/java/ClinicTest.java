import org.junit.jupiter.api.BeforeEach;

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
    }

    @org.junit.jupiter.api.Test
    void testAddTherapist() {
    }

    @org.junit.jupiter.api.Test
    void testRemoveTherapist() {
    }

    @org.junit.jupiter.api.Test
    void addPatient() {
    }

    @org.junit.jupiter.api.Test
    void removePatient() {
    }

    @org.junit.jupiter.api.Test
    void getAllPatients() {
    }

    @org.junit.jupiter.api.Test
    void getAllTherapists() {
    }

    @org.junit.jupiter.api.Test
    void getClinicCalendar() {
    }

    @org.junit.jupiter.api.Test
    void getClinicCalendar1() {
    }

    @org.junit.jupiter.api.Test
    void searchByExpertise() {
    }

    @org.junit.jupiter.api.Test
    void searchByTherapist() {
    }

    @org.junit.jupiter.api.Test
    void bookAppointment() {
    }

    @org.junit.jupiter.api.Test
    void cancelAppointment() {
    }

    @org.junit.jupiter.api.Test
    void attendAppointment() {
    }

    @org.junit.jupiter.api.Test
    void getAttendedCount() {
    }

    @org.junit.jupiter.api.Test
    void getAllAppointments() {
    }

    @org.junit.jupiter.api.Test
    void getAppointmentReport() {
    }
}