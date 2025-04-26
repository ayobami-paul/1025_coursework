import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();

        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.println("\n=== Boost Physio Clinic Booking System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. Change Appointment");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. Attend Appointment");
            System.out.println("7. Print Report");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("\nEnter First Name: ");
                    String firstName = scanner.nextLine().trim();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine().trim();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine().trim();
                    System.out.print("Enter Telephone: ");
                    String phone = scanner.nextLine().trim();

                    Patient newPatient = new Patient(firstName, lastName);
                    newPatient.addAddress(address);
                    newPatient.addPhone(phone);

                    clinic.addPatient(newPatient);
                    System.out.println("Patient Added");
                    System.out.println(newPatient.getPatientDetail());
                    break;

                case 2:
                    System.out.println("\nRemove Patient");

                    System.out.print("Enter Patient First Name: ");
                    String fName = scanner.nextLine().trim();
                    System.out.print("Enter Patient Last Name: ");
                    String lName = scanner.nextLine().trim();

                    Patient patientToRemove = clinic.findPatientByName(fName, lName);

                    if(patientToRemove == null){
                        System.out.println("Patient not found! Please register the patient first.");
                        break;
                    }

                    clinic.removePatient(patientToRemove);
                    break;

                case 3:
                    System.out.println("\nBook Appointment");

                    // Get and validate patient name
                    String pFirstName, pLastName;
                    do {
                        System.out.print("Enter Patient First Name: ");
                        pFirstName = scanner.nextLine().trim();
                        if (pFirstName.isEmpty()) {
                            System.out.println("First name cannot be empty!");
                        }
                    } while (pFirstName.isEmpty());

                    do {
                        System.out.print("Enter Patient Last Name: ");
                        pLastName = scanner.nextLine().trim();
                        if (pLastName.isEmpty()) {
                            System.out.println("Last name cannot be empty!");
                        }
                    } while (pLastName.isEmpty());

                    Patient foundPatient = clinic.findPatientByName(pFirstName, pLastName);
                    if (foundPatient == null) {
                        System.out.println("Patient not found! Please register the patient first.");
                        break;
                    }

                    // display therapist information
                    clinic.getAllTherapists();

                    // Get search option
                    int searchOption;
                    while (true) {
                        System.out.println("1. Search appointment by Expertise");
                        System.out.println("2. Search appointment by Physiotherapist Name");
                        System.out.print("Select search option: ");

                        if (scanner.hasNextInt()) {
                            searchOption = scanner.nextInt();
                            scanner.nextLine();
                            if (searchOption == 1 || searchOption == 2) break;
                            System.out.println("Invalid option. Please enter 1 or 2.");
                        } else {
                            System.out.println("Invalid input. Please enter a number (1 or 2).");
                            scanner.nextLine();
                        }
                    }

                    // Perform search
                    if (searchOption == 1) {
                        System.out.print("Enter expertise: ");
                        String expertise = scanner.nextLine();
                        if(clinic.searchExpertise(expertise)){
                            clinic.searchByExpertise(expertise);
                        }else {
                            System.out.println("Expertise not found!");
                            break;
                        }

                    } else {
                        System.out.print("Enter Physiotherapist Name: ");
                        String name = scanner.nextLine();
                        if(clinic.searchTherapistName(name)){
                            clinic.searchByTherapist(name);
                        } else {
                            System.out.println("Therapist not found!");
                            break;
                        }

                    }

                    // Get appointment ID
                    String appointmentId;
                    do {
                        System.out.print("\nEnter appointment Id to confirm: ");
                        appointmentId = scanner.nextLine().trim();
                        if (appointmentId.isEmpty()) {
                            System.out.println("\nAppointment ID cannot be empty!");
                        }
                    } while (appointmentId.isEmpty());

                    // Book appointment
                    try {
                        clinic.bookAppointment(foundPatient, appointmentId);
                    } catch (Exception e) {
                        System.out.println("Error booking appointment: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("\nEnter Patient First Name: ");
                    String paFirstName = scanner.nextLine();
                    System.out.print("Enter Patient Last Name: ");
                    String paLastName = scanner.nextLine();

                    Patient existingPatient = clinic.findPatientByName(paFirstName, paLastName);

                    if(existingPatient == null){
                        System.out.println("Patient not found! Please register the patient first.");
                        break;
                    } else {
                        System.out.println("Patient found");
                    }

                    System.out.print("Enter previous appointment ID: ");
                    String oldAppId = scanner.nextLine();
                    clinic.cancelAppointment(oldAppId);

                    System.out.print("Enter new appointment Id: ");
                    String newAppID = scanner.nextLine();

                    clinic.bookAppointment(existingPatient, newAppID);
                    break;

                case 5:
                    System.out.print("\nEnter appointment ID to cancel: ");
                    String cancelId = scanner.nextLine();

                    clinic.cancelAppointment(cancelId);
                    break;

                case 6:
                    System.out.print("\nEnter appointment ID to mark as attended: ");
                    String attendId = scanner.nextLine();

                    clinic.attendAppointment(attendId);
                    break;

                case 7:
                    int reportOption;
                    while (true) {
                        System.out.println("1. Generate Clinic Appointments Report");
                        System.out.println("2. Generate Report by Physiotherapist ");
                        System.out.print("Select report option: ");

                        if (scanner.hasNextInt()) {
                            reportOption = scanner.nextInt();
                            scanner.nextLine();
                            if (reportOption == 1 || reportOption == 2) break;
                            System.out.println("Invalid option. Please enter 1 or 2.");
                        } else {
                            System.out.println("Invalid input. Please enter a number (1 or 2).");
                            scanner.nextLine();
                        }
                    }

                    if (reportOption == 1) {
                        clinic.getAppointmentReport();
                        break;

                    } else {
                        System.out.print("Enter Physiotherapist Name: ");
                        String name = scanner.nextLine();
                        if(clinic.searchTherapistName(name)){
                            clinic.getAppointmentReportByTherapist(name);
                        } else {
                            System.out.println("Therapist not found!");
                            break;
                        }
                    }

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