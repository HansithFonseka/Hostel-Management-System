import java.util.*;

public class Student {
    private String name;
    private int RoomNumber;
    private int ListOfPayments;
    private String roomType;

    public Student(String name, int roomNumber, int listOfPayments, String roomType) {
        this.name = name;
        this.RoomNumber = roomNumber;
        this.ListOfPayments = listOfPayments;
        this.roomType = roomType;
    }

    // connect this wiht mysql;........................
    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }


    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.RoomNumber = roomNumber;
    }

    public int getListOfPayments() {
        return ListOfPayments;
    }

    public void setListOfPayments(int listOfPayments) {
        this.ListOfPayments = listOfPayments;
    }

    // add a student
    public static void addStudent(ArrayList<Student> students, String name, int roomNumber, int listOfPayments, String roomType) {
        students.add(new Student(name, roomNumber, listOfPayments, roomType));
    }

    // remove a student
    public void removeStudent(String name) {
        if (this.name.equals(name)) {
            this.name = null;
            this.RoomNumber = 0;
            this.ListOfPayments = 0;
        }
    }

    // list all students
    public void listStudents() {
        System.out.println("Name: " + name + ", Room Number: " + RoomNumber + ", Room Type: " +roomType);
    }

    // check room availability
    public boolean checkRoomAvailability(int roomNumber) {
        return this.RoomNumber == roomNumber;
    }

    // record monthly payments
    public void recordMonthlyPayments(int amount) {
        this.ListOfPayments += amount;
    }

    // display the payment history of a student
    public void displayPaymentHistory() {
        System.out.println("Payment History: $" + ListOfPayments);
    }

    // calculate the total payment for a room
    public int calculateTotalPaymentForRoom(int roomNumber) {
        if (this.RoomNumber == roomNumber) {
            return ListOfPayments;
        } else {
            return 0;
        }
    }

    // check the payment status of a student
    public String checkPaymentStatus() {
        if (this.ListOfPayments == 0) {
            return "Payment Status: Unpaid";
        } else {
            return "Payment Status: Paid";
        }
    }

    // identify tenants with missing payments
    public static ArrayList<Student> identifyTenantsWithMissingPayments(ArrayList<Student> students) {
        ArrayList<Student> tenantsWithMissingPayments = new ArrayList<>();
        for (Student student : students) {
            if (student.ListOfPayments == 0) {
                tenantsWithMissingPayments.add(student);
            }
        }
        return tenantsWithMissingPayments;
    }
}
