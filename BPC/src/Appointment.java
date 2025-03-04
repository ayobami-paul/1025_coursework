public class Appointment {
    private int id;
    private String treatmentType;
    private String date;
    private String time;
    private String status;


    public Appointment() {

    }

    public void bookAppointment() {
        // accept treatment, physio name and time
        // if time and physio exists, add treatment, patient and status to appointment
        status = "Booked";
    }

    public void cancelAppointment(int id){
        status = "Cancelled";
    }

    public void getAppointment(int id){

    }

    public void getAllAppointments(){

    }
}
