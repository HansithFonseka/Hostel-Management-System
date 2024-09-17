import java.util.ArrayList;
import java.util.Scanner;

public class StudentHostel {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        final int TOTAL_ROOMS = 50;

        System.out.println("--- Student Hostel Management System ---");
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
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

            
        }
        scanner.close();
    }
}

    