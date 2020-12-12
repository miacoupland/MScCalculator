import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("MSc Computer Science Calculator");
        Controller c = new Controller();
        c.read();
        primaryStage.setScene(new Scene(addComponents(c), 800,500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public GridPane addComponents(Controller c) {
        GridPane componentGroup = new GridPane();
        componentGroup.add(c.moduleName, 0, 0);
        componentGroup.add(c.coursework1, 1, 0);
        componentGroup.add(c.coursework2, 2, 0);
        componentGroup.add(c.coursework3, 3, 0);
        componentGroup.add(c.button, 3, 13);
        componentGroup.add(c.overallAvg, 4, 13);
        componentGroup.add(c.degreeTotal, 5, 13);

        c.button.setOnAction((event) -> {
            int weightedAvg = 0;
            int avg = 0;
            int count = 0;
            for (Course course: c.getCourses()) {
                if (course.getAverage() > 0) {
                    avg += course.getAverage();
                    if (course.getModWeight() == 11.1) {
                        weightedAvg += course.getAverage() * 20/180;
                        count++;
                    } else if (course.getModWeight() == 33.3) {
                        weightedAvg += course.getAverage() * 60/180;
                        count++;
                    } else {
                        weightedAvg += course.getAverage() * 10/180;
                        count++;
                    }
                }
            }
            c.overallAvg.setText("Current Average: " + avg / count);
            c.degreeTotal.setText("Degree Total: " + weightedAvg);
        });

        int j = 1;
        for (int i = 0; i < c.getCourses().size(); i++) {
            componentGroup.add(c.getCourses().get(i).getLabel(), 0, j);
            j++;
        }

        int m = 1;
        //this adds each component to the component group, one by one checking if they have multiple courseworks
        for (int i = 0; i < c.getCourses().size(); i++) {
            componentGroup.add(c.getCourses().get(i).coursework1, 1, m);
            if (c.getCourses().get(i).getAssignmentNo() > 1) {
                componentGroup.add(c.getCourses().get(i).coursework2, 2, m);
            }
            if (c.getCourses().get(i).getAssignmentNo() > 2) {
                componentGroup.add(c.getCourses().get(i).coursework3, 3, m);
            }
            componentGroup.add(c.getCourses().get(i).average, 4, m);
            m++;
        }
        //sets padding etc, makes it look nicer
        componentGroup.setHgap(10);
        componentGroup.setVgap(10);
        componentGroup.setPadding(new Insets(10, 10, 10, 10));
        return componentGroup;
    }
}
