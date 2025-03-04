public class Appointment {
    private int id;
    private String treatmentType;
    private String date;
    private String time;
    private String status;


    public Appointment() {

    }

    public void bookAppointment() {
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
