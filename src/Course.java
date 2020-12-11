import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

public class Course {
    public Label label;
    public TextField coursework1;
    public TextField coursework2;
    public TextField coursework3;
    public Label average;

    public Course(String name) {
        label = new Label(name);
        coursework1 = new TextField();
        coursework1.setMaxWidth(50);
        coursework2 = new TextField();
        coursework2.setMaxWidth(50);
        coursework2.setVisible(false);
        coursework3 = new TextField();
        coursework3.setVisible(false);
        average = new Label("Average: ");
        coursework1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                average.setText("Average: " + getAverage());
            }
        });
    }

    public Course(String name, Boolean bool1) {
        label = new Label(name);
        coursework1 = new TextField();
        coursework2 = new TextField();
        coursework1.setMaxWidth(50);
        coursework2.setMaxWidth(50);
        coursework3 = new TextField();
        coursework3.setVisible(false);
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
    }

    public Course(String name, Boolean bool1, Boolean bool2) {
        label = new Label(name);
        coursework1 = new TextField();
        coursework2 = new TextField();
        coursework3 = new TextField();
        coursework1.setMaxWidth(50);
        coursework2.setMaxWidth(50);
        coursework3.setMaxWidth(50);
        average = new Label("Average: ");

        coursework1.textProperty().addListener(new ChangeListener<String>() {
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

    public TextField getCoursework1() {
        if (coursework1.hasProperties()) {
            return coursework1;
        } else {
            return null;
        }
    }

    public TextField getCoursework2() {
        if (coursework2.isVisible()) {
            return coursework2;
        } else {
            return null;
        }
    }

    public TextField getCoursework3() {
        if (coursework3.isVisible()) {
            return coursework3;
        } else {
            return null;
        }
    }

    public int getAverage() {
        if (!coursework1.getText().isEmpty()) {
            if (!coursework2.getText().isEmpty()) {
                if (!coursework3.getText().isEmpty()) {
                    return (Integer.valueOf(coursework1.getText()) +
                            Integer.valueOf(coursework2.getText()) +
                            Integer.valueOf(coursework3.getText())) / 3;
                }
                return (Integer.valueOf(coursework1.getText()) +
                        Integer.valueOf(coursework2.getText())) / 2;
            }
            return Integer.valueOf(coursework1.getText());
        }
        return -1;
    }

}
