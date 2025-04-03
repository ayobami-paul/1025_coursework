import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();

        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.println("=== Boost Physio Clinic Booking System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. Change Booking");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Attend Appointment");
            System.out.println("7. Print Report");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Full Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Telephone: ");
                    String phone = scanner.nextLine();

                    Patient newPatient = new Patient(firstName, lastName);
                    newPatient.addAddress(address);
                    newPatient.addPhone(phone);

                    clinic.addPatient(newPatient);
                    break;

                case 2:
                    System.out.print("Enter Patient name to remove: ");
                    String removeId = scanner.nextLine();

//                    for
                    Patient p ;
                    clinic.removePatient(p);
                    break;

                case 3:
                    System.out.println("Book Appointment:");
                    System.out.println("1. Search by Expertise");
                    System.out.println("2. Search by Physiotherapist Name");
                    int searchOption = scanner.nextInt();
                    scanner.nextLine();

                    if (searchOption == 1) {
                        System.out.print("Enter expertise: ");
                        String expertise = scanner.nextLine();

                        clinic.searchByExpertise(expertise);

                    } else if (searchOption == 2) {
                        System.out.print("Enter Physiotherapist Name: ");
                        String name = scanner.nextLine();

                        clinic.searchByTherapist(name);
                    }

                    System.out.print("Enter new appointment Id: ");
                    String appointmentId = scanner.nextLine();

                    clinic.bookAppointment(appointmentId);

                case 4:
                    System.out.print("Enter previous appointment ID: ");
                    String bookingId = scanner.nextLine();

                    System.out.print("Enter new appointment Id: ");
                    String newAppID = scanner.nextLine();

                    clinic.bookAppointment(newAppID);
                    break;

                case 5:
                    System.out.print("Enter appointment ID to cancel: ");
                    String cancelId = scanner.nextLine();

                    clinic.cancelAppointment(cancelId);
                    break;

                case 6:
                    System.out.print("Enter appointment ID to mark as attended: ");
                    String attendId = scanner.nextLine();

                    clinic.attendAppointment(attendId);
                    break;


                case 7:
                    clinic.getAllAppointments();
                    clinic.getAppointmentReport();
                    break;

                case 8:
                    done = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}