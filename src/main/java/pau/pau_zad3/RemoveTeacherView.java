package pau.pau_zad3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RemoveTeacherView {

    @FXML
    private TextField textFieldName, textFieldSurname;
    private MainView mainView;
    private Stage stage;

    public void setMainView(MainView mainView) { this.mainView = mainView; }

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    public void removeTeacher(ActionEvent event) {
        String name = textFieldName.getText();
        String surname = textFieldSurname.getText();

        if(textFieldName.getText().isEmpty() || textFieldSurname.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Empty fields");
            alert.setContentText("Fill in all the fields!");
            alert.showAndWait();
        }
        else if(mainView.getListTeacher().stream().noneMatch(t -> t.getName().equalsIgnoreCase(name) && t.getSurname().equalsIgnoreCase(surname))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Teacher does not exist.");
            alert.setContentText("Enter a valid teacher name and surname!");
            alert.showAndWait();
        }
        else {
            try {
                Teacher t = mainView.getListTeacher().stream().filter(teacher -> teacher.getName().equalsIgnoreCase(name) && teacher.getSurname().equalsIgnoreCase(surname)).
                        findFirst().get();

                mainView.getListTeacher().remove(t);

                for(ClassTeacher group : mainView.getListClass()) {
                    if(group.teachers.contains(t)) {
                        group.teachers.remove(t);
                    }
                }

                mainView.getTableTeachers().refresh();
                mainView.getTableClass().refresh();

                textFieldSurname.clear();
                textFieldName.clear();

            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Cannot remove teacher.");
                alert.showAndWait();

            }
        }
    }

    public void cancel(ActionEvent event) {
        stage.close();
    }
}
