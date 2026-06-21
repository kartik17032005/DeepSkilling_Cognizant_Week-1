package Week_1.Design_Patterns.MVCPatternExample;

public class Main {
    static void main() {
        // Fetch student record from a simulated database
        Student student = retrieveStudentFromDatabase();

        // Create a view to show student details on console
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        System.out.println("--- Initial Student View ---");
        controller.updateView();
        System.out.println();

        // Update model data via controller
        System.out.println("--- Updating Student Grade to A+ ---");
        controller.setStudentGrade("A+");

        // Display updated student details
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        return new Student("Alice Smith", "S12345", "A");
    }
}
