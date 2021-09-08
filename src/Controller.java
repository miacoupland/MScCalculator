import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private ArrayList<Course> Courses;

    public Label moduleName = new Label("Course Title");
    public Label coursework1 = new Label("CW 1 (%)");
    public Label coursework2 = new Label("CW 2 (%)");
    public Label coursework3 = new Label("CW 3 (%)");
    public Button button = new Button("Calculate!");
    public Label overallAvg = new Label("Current Average: ");
    public Label degreeTotal = new Label("Degree Total: ");

    public Controller() {
        Courses = new ArrayList<>();
    }

    public ArrayList<Course> read() throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader("src/courses.csv"));
        try {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] pieces = row.split(",");
                Course c1 = new Course(pieces[0], pieces[1], Integer.valueOf(pieces[2]), Double.valueOf(pieces[3]));
                Courses.add(c1);
                System.out.println(c1.getAssignmentNo());
            }
        } catch (Exception e) {
            System.out.println("There was a problem reading the file.");
            e.printStackTrace();
        }
        return Courses;
    }

    public ArrayList<Course> getCourses() {
        return this.Courses;
    }

}
