import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("MSc Computer Science Calculator");
        primaryStage.setScene(new Scene(addComponents()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public GridPane addComponents() {
        Button button = new Button("Calculate!");
        ArrayList<Course> courses = new ArrayList<>();
        Course csc8011 = new Course("CSC8011 - Introduction to Software Development");
        courses.add(csc8011);
        Course csc8012 = new Course("CSC8012 - Software Development Techniques and Tools");
        courses.add(csc8012);
        Course csc8013 = new Course("CSC8013 - Professional Skills and Portfolio");
        courses.add(csc8013);
        Course csc8014 = new Course("CSC8014 - Software Development Techniques and Tools", true);
        courses.add(csc8014);
        Course csc8015 = new Course("CSC8015 - Cybersecurity", true, true);
        courses.add(csc8015);
        Course csc8016 = new Course("CSC8016 - Advanced Programming");
        courses.add(csc8016);
        Course csc8017 = new Course("CSC8017 - Database Systems", true);
        courses.add(csc8017);
        Course csc8018 = new Course("CSC8018 - Web Technologies");
        courses.add(csc8018);
        Course csc8019 = new Course("CSC8019 - Software Engineering and Team Project", true, true);
        courses.add(csc8019);
        Course csc8021 = new Course("CSC8021 - Computer Networks", true);
        courses.add(csc8021);
        Course csc8022 = new Course("CSC8022 - Human Computer Interaction", true);
        courses.add(csc8022);
        Course csc8099 = new Course("CSC8099 - Project and Dissertation for MSc Computer Science");
        courses.add(csc8099);

        Label overallAvg = new Label("Current Average: ");
        GridPane componentGroup = new GridPane();
        componentGroup.add(button, 3, 12);
        componentGroup.add(overallAvg, 4, 12);
        componentGroup.add(csc8011.label, 0, 0);
        componentGroup.add(csc8011.coursework1, 1, 0);
        componentGroup.add(csc8011.average, 4, 0);
        componentGroup.add(csc8012.label, 0, 1);
        componentGroup.add(csc8012.coursework1, 1, 1);
        componentGroup.add(csc8012.average, 4, 1);
        componentGroup.add(csc8013.label, 0, 2);
        componentGroup.add(csc8013.coursework1, 1, 2);
        componentGroup.add(csc8013.average, 4, 2);
        componentGroup.add(csc8014.label, 0, 3);
        componentGroup.add(csc8014.coursework1, 1, 3);
        componentGroup.add(csc8014.coursework2, 2, 3);
        componentGroup.add(csc8014.average, 4, 3);
        componentGroup.add(csc8015.label, 0, 4);
        componentGroup.add(csc8015.coursework1, 1, 4);
        componentGroup.add(csc8015.coursework2, 2, 4);
        componentGroup.add(csc8015.coursework3, 3, 4);
        componentGroup.add(csc8015.average, 4, 4);
        componentGroup.add(csc8016.label, 0, 5);
        componentGroup.add(csc8016.coursework1, 1, 5);
        componentGroup.add(csc8016.average, 4, 5);
        componentGroup.add(csc8017.label, 0, 6);
        componentGroup.add(csc8017.coursework1, 1, 6);
        componentGroup.add(csc8017.coursework2, 2, 6);
        componentGroup.add(csc8017.average, 4, 6);
        componentGroup.add(csc8018.label, 0, 7);
        componentGroup.add(csc8018.coursework1, 1, 7);
        componentGroup.add(csc8018.average, 4, 7);
        componentGroup.add(csc8019.label, 0, 8);
        componentGroup.add(csc8019.coursework1, 1, 8);
        componentGroup.add(csc8019.coursework2, 2, 8);
        componentGroup.add(csc8019.coursework3, 3, 8);
        componentGroup.add(csc8019.average, 4, 8);
        componentGroup.add(csc8021.label, 0, 9);
        componentGroup.add(csc8021.coursework1, 1, 9);
        componentGroup.add(csc8021.coursework2, 2, 9);
        componentGroup.add(csc8021.average, 4, 9);
        componentGroup.add(csc8022.label, 0, 10);
        componentGroup.add(csc8022.coursework1, 1, 10);
        componentGroup.add(csc8022.coursework2, 2, 10);
        componentGroup.add(csc8022.average, 4, 10);
        componentGroup.add(csc8099.label, 0, 11);
        componentGroup.add(csc8099.coursework1, 1, 11);
        componentGroup.add(csc8099.average, 4, 11);
        componentGroup.setHgap(10);
        componentGroup.setVgap(10);
        componentGroup.setPadding(new Insets(10, 10, 10, 10));

        button.setOnAction((event) -> {
            int avg = 0;
            int count = 0;
            for (Course course: courses) {
                if (course.getAverage() > 0) {
                    avg += course.getAverage();
                    count++;
                }
            }
            int overallAverage = avg / count;
            overallAvg.setText("Current Average: " + overallAverage);
        });

        return componentGroup;
    }
}
