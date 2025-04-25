# Boost Physio Clinic Booking System

## Overview
Boost Physio Clinic Booking System is a Java-based console application designed to manage appointments between patients and therapists at a physical therapy clinic. The system allows clinic staff to add and remove patients, book and reschedule appointments, and generate reports on clinic operations.

## Features
- Patient management (add, remove, search)
- Therapist expertise and treatment management
- Appointment booking, rescheduling, and cancellation
- Appointment status tracking (Available, Booked, Cancelled, Attended)
- Report generation for appointment statistics

## System Requirements
- Java Development Kit (JDK) 8 or higher
- Command-line interface or IDE with Java support

## Installation
1. Clone the repository or download the source files
2. Navigate to the project directory
3. Compile the Java files:
   ```
   javac *.java
   ```
4. Run the application:
   ```
   java Main
   ```

## Project Structure
- `Main.java`: Entry point containing the user interface
- `Member.java`: Abstract base class for people in the system
- `Patient.java`: Class representing clinic patients
- `Therapist.java`: Class representing healthcare providers
- `Appointment.java`: Class representing scheduled appointments
- `Clinic.java`: Core management class coordinating all operations

## Usage Guide

### Main Menu
When you start the application, you'll be presented with these options:
```
=== Boost Physio Clinic Booking System ===
1. Add Patient
2. Remove Patient
3. Book Appointment
4. Change Appointment
5. Cancel Appointment
6. Attend Appointment
7. Print Report
8. Exit
```

### Adding a Patient
1. Select option 1
2. Enter the patient's first name, last name, address, and phone number
3. The system will confirm when the patient is added

### Removing a Patient
1. Select option 2
2. Enter the patient's first and last name
3. The system will remove the patient if found

### Booking an Appointment
1. Select option 3
2. Enter the patient's first and last name
3. Choose to search by expertise or therapist name
4. View available appointments and note the appointment ID
5. Enter the appointment ID to confirm booking

### Changing an Appointment
1. Select option 4
2. Enter the patient's first and last name
3. Enter the previous appointment ID to cancel
4. Enter the new appointment ID to book

### Cancelling an Appointment
1. Select option 5
2. Enter the appointment ID
3. The system will confirm cancellation

### Marking an Appointment as Attended
1. Select option 6
2. Enter the appointment ID
3. The system will mark the appointment as attended

### Generating Reports
1. Select option 7
2. The system will display a report of appointments grouped by therapist with attendance counts

## Sample Data
The system comes pre-populated with:
- Two therapists:
  - Bob Dylan (physiotherapy, osteopathy)
  - Emily Smith (osteopathy)
- One patient:
  - John Smith

## Assumptions
The system operates under several assumptions:
- Single clinic operation
- Fixed working hours (10:00 AM to 4:00 PM, Monday-Friday)
- One-hour appointments with no overlaps
- No persistent storage (data exists only during program execution)
- No authentication system or user roles

