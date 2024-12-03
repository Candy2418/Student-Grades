import java.util.HashMap;
import java.util.Scanner;

public class StudentGradesMap {
    private HashMap<String, String> studentGrades;

    public StudentGradesMap() {
        this.studentGrades = new HashMap<>();
    }

    public void add_student(String id, String grade) {
        if (!studentGrades.containsKey(id)) {
            studentGrades.put(id, grade);
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student ID already exists.");
        }
    }

    public void get_grade(String id) {
        if (studentGrades.containsKey(id)) {
            System.out.println("Grade of student with ID " + id + " is: " + studentGrades.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    public void update_grade(String id, String grade) {
        if (studentGrades.containsKey(id)) {
            studentGrades.put(id, grade);
            System.out.println("Student grade updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void remove_student(String id) {
        if (studentGrades.remove(id) != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayData() {
        if (studentGrades.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            System.out.println("All Students and Grades:");
            studentGrades.forEach((id, grade) -> System.out.println("ID: " + id + ", Grade: " + grade));
        }
    }

    public static void main(String[] args) {
        StudentGradesMap gradesMap = new StudentGradesMap();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grades System");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student Grade");
            System.out.println("3. Update Student Grade");
            System.out.println("4. Remove Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id_Add = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade_Add = scanner.nextLine();
                    gradesMap.add_student(id_Add, grade_Add);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String id_Get = scanner.nextLine();
                    gradesMap.get_grade(id_Get);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String id_Update = scanner.nextLine();
                    System.out.print("Enter New Grade: ");
                    String grade_Update = scanner.nextLine();
                    gradesMap.update_grade(id_Update, grade_Update);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    String id_Remove = scanner.nextLine();
                    gradesMap.remove_student(id_Remove);
                    break;
                case 5:
                    gradesMap.displayData();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

