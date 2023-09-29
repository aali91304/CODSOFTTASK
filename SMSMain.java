import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private char grade;

    // Constructor
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Remove a student
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    // Search for a student
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() +
                    ", Roll Number: " + student.getRollNumber() +
                    ", Grade: " + student.getGrade());
        }
    }

    // Save student data to a file
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Student data saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load student data from a file
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (ArrayList<Student>) ois.readObject();
            System.out.println("Student data loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
public class SMSMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    char grade = scanner.next().charAt(0);

                    Student newStudent = new Student(name, rollNumber, grade);
                    system.addStudent(newStudent);
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    system.removeStudent(removeRollNumber);
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student foundStudent = system.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found - Name: " + foundStudent.getName() +
                                ", Roll Number: " + foundStudent.getRollNumber() +
                                ", Grade: " + foundStudent.getGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    system.displayAllStudents();
                    break;

                case 5:
                    System.out.print("Enter filename to save: ");
                    String saveFilename = scanner.next();
                    system.saveToFile(saveFilename);
                    break;

                case 6:
                    System.out.print("Enter filename to load: ");
                    String loadFilename = scanner.next();
                    system.loadFromFile(loadFilename);
                    break;

                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
