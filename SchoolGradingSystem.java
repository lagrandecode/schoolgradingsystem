import java.util.ArrayList;
import java.util.Scanner;

// SchoolGradingSystem Class
public class SchoolGradingSystem {
    // List to store all students
    private ArrayList<Student> students = new ArrayList<>();
    // List to store all courses
    private ArrayList<Course> courses = new ArrayList<>();
    // Scanner for user input
    private Scanner scanner = new Scanner(System.in);

    // Method to add a new student to the system
    public void addStudent() {
        System.out.print("Enter Student ID: "); // Prompt for student ID
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: "); // Prompt for student name
        String name = scanner.nextLine();
        students.add(new Student(id, name)); // Create a new Student object and add to the list
        System.out.println("Student Added Successfully!"); // Confirmation message
    }

    // Method to add a new course to the system
    public void addCourse() {
        System.out.print("Enter Course ID: "); // Prompt for course ID
        String courseId = scanner.nextLine();
        System.out.print("Enter Course Name: "); // Prompt for course name
        String courseName = scanner.nextLine();
        courses.add(new Course(courseId, courseName)); // Create a new Course object and add to the list
        System.out.println("Course Added Successfully!"); // Confirmation message
    }

    // Method to enroll a student in a course
    public void enrollStudent() {
        System.out.print("Enter Student ID: "); // Prompt for student ID
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Course Name: "); // Prompt for course name
        String courseName = scanner.nextLine();

        // Find the student and course objects
        Student student = findStudentById(studentId);
        Course course = findCourseByName(courseName);

        if (student != null && course != null) { // Check if both student and course exist
            student.enrollInCourse(course); // Enroll the student in the course
            System.out.println("Student Enrolled Successfully!"); // Confirmation message
        } else {
            System.out.println("Student or Course Not Found."); // Error message if not found
        }
    }

    // Method to record a grade for a student in a course
    public void recordGrade() {
        System.out.print("Enter Student ID: "); // Prompt for student ID
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Course Name: "); // Prompt for course name
        String courseName = scanner.nextLine();
        System.out.print("Enter Grade: "); // Prompt for grade
        double grade = scanner.nextDouble();

        // Find the student object
        Student student = findStudentById(studentId);
        if (student != null) { // Check if student exists
            student.recordGrade(courseName, grade); // Record the grade
            System.out.println("Grade Recorded Successfully!"); // Confirmation message
        } else {
            System.out.println("Student Not Found."); // Error message if not found
        }
    }

    // Method to display a student report
    public void displayStudentReport() {
        System.out.print("Enter Student ID: "); // Prompt for student ID
        int studentId = scanner.nextInt();

        // Find the student object
        Student student = findStudentById(studentId);
        if (student != null) { // Check if student exists
            student.displayDetails(); // Display student details and grades
        } else {
            System.out.println("Student Not Found."); // Error message if not found
        }
    }

    // Helper method to find a student by ID
    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) { // Check for matching ID
                return student;
            }
        }
        return null; // Return null if not found
    }

    // Helper method to find a course by name
    private Course findCourseByName(String name) {
        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(name)) { // Check for matching name
                return course;
            }
        }
        return null; // Return null if not found
    }

    // Menu method to display options and handle user choices
    public void menu() {
        int choice;
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Record Grade");
            System.out.println("5. Display Student Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> addStudent(); // Call addStudent method
                case 2 -> addCourse(); // Call addCourse method
                case 3 -> enrollStudent(); // Call enrollStudent method
                case 4 -> recordGrade(); // Call recordGrade method
                case 5 -> displayStudentReport(); // Call displayStudentReport method
                case 6 -> System.out.println("Exiting..."); // Exit message
                default -> System.out.println("Invalid choice. Try again."); // Error for invalid input
            }
        } while (choice != 6); // Loop until the user chooses to exit
    }
}\\
