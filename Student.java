import java.util.ArrayList;

// Student Class
public class Student {
    // Private fields to encapsulate student data
    private int id;
    private String name;
    private ArrayList<Course> courses = new ArrayList<>(); // List of courses the student is enrolled in
    private ArrayList<Double> grades = new ArrayList<>(); // List of grades for the corresponding courses

    // Constructor to initialize student ID and name
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for student ID
    public int getId() {
        return id;
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    // Method to enroll a student in a course
    public void enrollInCourse(Course course) {
        courses.add(course); // Add the course to the student's course list
        grades.add(0.0); // Initialize the grade for the course to 0
    }

    // Method to record a grade for a specific course
    public void recordGrade(String courseName, double grade) {
        for (int i = 0; i < courses.size(); i++) { // Loop through the courses to find the matching course
            if (courses.get(i).getCourseName().equalsIgnoreCase(courseName)) {
                grades.set(i, grade); // Update the grade for the course
                return;
            }
        }
        System.out.println("Course not found for this student."); // Print error if course not found
    }

    // Method to calculate the average grade across all courses
    public double calculateAverageGrade() {
        double total = 0;
        for (double grade : grades) { // Sum up all grades
            total += grade;
        }
        return grades.isEmpty() ? 0 : total / grades.size(); // Return the average grade
    }

    // Method to display student details and grades
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name); // Print ID and name
        System.out.println("Courses and Grades:");
        for (int i = 0; i < courses.size(); i++) { // Loop through courses and grades
            System.out.println("  - " + courses.get(i).getCourseName() + ": " + grades.get(i));
        }
        System.out.println("Average Grade: " + calculateAverageGrade()); // Print the average grade
    }
}
