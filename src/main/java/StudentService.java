import java.util.Scanner;

public class StudentService {

    Scanner inp = new Scanner(System.in);
    private final StudentRepo stRepo = new StudentRepo();

    public void createTable() {
        stRepo.createTable();
    }

    public void save() {

        System.out.println("NAME: ");
        String name = inp.nextLine().trim();
        System.out.println("LAST NAME: ");
        String lastname = inp.nextLine().trim();
        System.out.println("CITY: ");
        String city = inp.nextLine().trim();
        System.out.println("AGE: ");
        int age = inp.nextInt();
        inp.nextLine();

        Student newStd = new Student(name,lastname,city,age);
        stRepo.save(newStd);

    }

    public void findById() {

        System.out.println("Enter student ID: ");
        int id = inp.nextInt();
        Student std = stRepo.getById(id);
        System.out.println(std);

    }

    public void getAllStudents() {

        stRepo.getAll();

    }

    public void deleteById() {

        getAllStudents();
        System.out.println("Enter the student ID to DELETE:");
        int id = inp.nextInt();
        inp.nextLine();
        stRepo.delete(id);

    }

    public void updateById() {

        getAllStudents();
        System.out.println("Enter the student ID to UPDATE:");
        int id = inp.nextInt();
        inp.nextLine();

        System.out.println("NAME: ");
        String name = inp.nextLine().trim();
        System.out.println("LAST NAME: ");
        String lastname = inp.nextLine().trim();
        System.out.println("CITY: ");
        String city = inp.nextLine().trim();
        System.out.println("AGE: ");
        int age = inp.nextInt();
        inp.nextLine();
        stRepo.update(name,lastname,city,age,id);
    }

}
