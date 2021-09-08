import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Course {
    private String code;
    private String name;
    private int assignmentNo;
    private double modWeight;

    public Label label;
    public TextField coursework1;
    public TextField coursework2;
    public TextField coursework3;
    public Label average;

    public Course(String courseCode, String name, int assignmentNo, double weight) {
        this.code = courseCode;
        this.name = name;
        this.assignmentNo = assignmentNo;
        this.modWeight = weight;

        label = new Label(courseCode + " - " + name);
        coursework1 = new TextField();
        coursework1.setMaxWidth(50);
        coursework2 = new TextField();
        coursework2.setMaxWidth(50);
        coursework3 = new TextField();
        coursework3.setMaxWidth(50);
        average = new Label("Average: ");
        coursework1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                average.setText("Average: " + getAverage());
            }
        });
        coursework2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                average.setText("Average: " + getAverage());
            }
        });
        coursework3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                average.setText("Average: " + getAverage());
            }
        });
    }

    public double getAverage() {
        //(E10*F10)+(G10*H10)+(I10*J10) - maths logic
        if (getModWeight() == 11.1) {
            if (!coursework1.getText().isEmpty()) {
                if (!coursework2.getText().isEmpty()) {
                    if (!coursework3.getText().isEmpty()) {
                        return Math.round((Integer.valueOf(coursework1.getText()) * 0.80) +
                                (Integer.valueOf(coursework2.getText()) * 0.10) +
                                (Integer.valueOf(coursework3.getText()) * 0.10));
                    }
                    return Math.round((Integer.valueOf(coursework1.getText()) * 0.80) +
                            (Integer.valueOf(coursework2.getText()) * 0.10));
                }
                return Integer.valueOf(coursework1.getText());
            }
        }

        if (getModWeight() == 33.3) {
            if (!coursework1.getText().isEmpty()) {
                if (!coursework2.getText().isEmpty()) {
                    if (!coursework3.getText().isEmpty()) {
                        return Math.round((Integer.valueOf(coursework1.getText()) * 0.30) +
                                (Integer.valueOf(coursework2.getText()) * 0.20) +
                                (Integer.valueOf(coursework3.getText()) * 0.50));
                    }
                    return Math.round((Integer.valueOf(coursework1.getText()) * 0.30) +
                            (Integer.valueOf(coursework2.getText()) * 0.20));
                }
                return Integer.valueOf(coursework1.getText());
            }
        }

        if (!coursework1.getText().isEmpty()) {
            if (!coursework2.getText().isEmpty()) {
                return (Integer.valueOf(coursework1.getText()) +
                        Integer.valueOf(coursework2.getText())) / 2;
            }
            return Integer.valueOf(coursework1.getText());
        }
        return -1;
    }

    public int getAssignmentNo() {
        return this.assignmentNo;
    }

    public double getModWeight() {
        return this.modWeight;
    }

    public Label getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return code + " " + name + " has " + this.assignmentNo + " coursework assignments.";
    }
}
