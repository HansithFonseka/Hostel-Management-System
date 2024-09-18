import java.util.ArrayList;
import java.util.Scanner;

public class StudentHostel {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        final int TOTAL_ROOMS = 50;

        System.out.println("--- Student Hostel Management System ---");
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        try {
            while (choice != 10) {
                // Display menu
                System.out.println("\nChoose an option:");
                System.out.println("1. Add a new student");
                System.out.println("2. Remove a student");
                System.out.println("3. List All students");
                System.out.println("4. Check room Availability");
                System.out.println("5. Record Monthly Payments");
                System.out.println("6. Display the Payment History of a Student");
                System.out.println("7. Calculate the total payment for a room");
                System.out.println("8. Check the Payment Status of a Student");
                System.out.println("9. Identify Tenants with Missing Payments");
                System.out.println("10. Exit");
    
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
    
                switch (choice) {
                    case 1:
                        // Add a new student
                        System.out.println("Enter student details:");
                        System.out.print("Name: ");
                        String name = scanner.next();
                        System.out.print("Room Number (1-50): ");
                        int roomNumber = scanner.nextInt();
                        while (roomNumber < 1 || roomNumber > TOTAL_ROOMS) {
                            System.out.print("Invalid Room Number. Enter a number between 1 and 50: ");
                            roomNumber = scanner.nextInt();
                        }

                        System.out.println("Enter the Room type: AC / Non-AC");
                        String roomType = scanner.next();
                        
                        System.out.print("Initial Payment: ");
                        int initialPayment = scanner.nextInt();
    
                        Student.addStudent(students, name, roomNumber, initialPayment,roomType);
                        System.out.println("Student added successfully!");
                        break;

    
                    case 2:
                        // Remove a student
                        System.out.print("Enter the student's name to remove: ");
                        String removeName = scanner.next();
                        boolean removed = false;
                        for (Student student : students) {
                            if (student.getName().equals(removeName)) {
                                students.remove(student);
                                removed = true;
                                break;
                            }
                        }
                        if (removed) {
                            System.out.println("Student removed successfully!");
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;
    
                    case 3:
                        // List all students
                        if (students.isEmpty()) {
                            System.out.println("No students are currently staying in the hostel.");
                        } else {
                            System.out.println("List of Students:");
                            for (Student student : students) {
                                student.listStudents();
                            }
                        }
                        break;
    
                    case 4:
                        // Check room availability
                        System.out.print("Enter room number to check availability (1-50): ");
                        int roomToCheck = scanner.nextInt();
                        boolean available = true;
                        for (Student student : students) {
                            if (student.getRoomNumber() == roomToCheck) {
                                available = false;
                                break;
                            }
                        }
                        if (available) {
                            System.out.println("Room " + roomToCheck + " is available.");
                        } else {
                            System.out.println("Room " + roomToCheck + " is occupied.");
                        }
                        break;
    
                    case 5:
                        // Record monthly payments
                        System.out.print("Enter student's name to record payment: ");
                        String payName = scanner.next();
                        boolean found = false;
                        for (Student student : students) {
                            if (student.getName().equals(payName)) {
                                System.out.print("Enter payment amount: ");
                                int paymentAmount = scanner.nextInt();
                                student.recordMonthlyPayments(paymentAmount);
                                System.out.println("Payment recorded successfully!");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Student not found!");
                        }
                        break;
    
                    case 6:
                        // Display the payment history of a student
                        System.out.print("Enter student's name to view payment history: ");
                        String paymentHistoryName = scanner.next();
                        for (Student student : students) {
                            if (student.getName().equals(paymentHistoryName)) {
                                student.displayPaymentHistory();
                                break;
                            }
                        }
                        break;
    
                    case 7:
                        // Calculate the total payment for a room
                        System.out.print("Enter room number: ");
                        int totalRoomNumber = scanner.nextInt();
                        if(totalRoomNumber > 50 ||totalRoomNumber < 0){
                            System.out.println("Not a valid room number");
                            break;
                        }
                        int totalPayment = 0;
                        for (Student student : students) {
                            totalPayment = student.calculateTotalPaymentForRoom(totalRoomNumber);
                        }
                        System.out.println("Total payment for room " + totalRoomNumber + " is: $" + totalPayment);
                        break;
    
                    case 8:
                        // Check the payment status of a student
                        System.out.print("Enter student's name to check payment status: ");
                        String paymentStatusName = scanner.next();
                        for (Student student : students) {
                            if (student.getName().equals(paymentStatusName)) {
                                System.out.println(student.checkPaymentStatus());
                                break;
                            }
                        }
                        break;
    
                    case 9:
                        // Identify tenants with missing payments
                        ArrayList<Student> tenantsWithMissingPayments = Student.identifyTenantsWithMissingPayments(students);
                        if (tenantsWithMissingPayments.isEmpty()) {
                            System.out.println("All tenants have made their payments.");
                        } else {
                            System.out.println("Tenants with missing payments:");
                            for (Student student : tenantsWithMissingPayments) {
                                System.out.println(student.getName());
                            }
                        }
                        break;
    
                    case 10:
                        // Exit the program
                        System.out.println("Exiting the program...");
                        break;
    
                    default:
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }
            }
            
        } catch (Exception InputMismatchException) {
            System.out.println("Invalid input");
        }
       scanner.close();
    }
}

    