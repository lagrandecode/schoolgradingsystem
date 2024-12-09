// Course Class
public class Course {
    // Private fields for course data
    private String courseId;
    private String courseName;

    // Constructor to initialize course ID and name
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Getter for course ID
    public String getCourseId() {
        return courseId;
    }

    // Getter for course name
    public String getCourseName() {
        return courseName;
    }
}
