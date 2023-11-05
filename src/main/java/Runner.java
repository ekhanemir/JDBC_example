import java.util.Scanner;

public class Runner {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        displayMenu();

    }

    public static void displayMenu() {

        StudentService studentService = new StudentService();
        studentService.createTable();

        boolean exit = false;

        while (!exit) {
            System.out.println("=".repeat(10) + " JDBC DEMO " + "=".repeat(10));
            System.out.println("    1. Add a new student");
            System.out.println("    2. Find student By ID");
            System.out.println("    3. Get All students");
            System.out.println("    4. Delete student By ID");
            System.out.println("    5. Update student By ID");
            System.out.println("    0. Exit");
            System.out.println("    Enter your choice: ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    //save student
                    studentService.save();
                    break;

                case 2:
                    // find a student
                    studentService.findById();
                    break;

                case 3:
                    // get All student
                    studentService.getAllStudents();
                    break;

                case 4:
                    // delete student
                    studentService.deleteById();

                    break;
                case 5:
                    // Update student
                    studentService.updateById();
                    break;
                case 0:
                    System.out.println("See you again...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }

        }

    }

}
