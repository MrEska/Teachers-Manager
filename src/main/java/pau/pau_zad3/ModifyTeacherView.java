package pau.pau_zad3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifyTeacherView {

    @FXML
    private TextField textFieldTeacher, textFieldName, textFieldSurname, textFieldBirth, textFieldSalary, textFieldCondition;
    private MainView mainView;
    private Stage stage;

    public void setMainView(MainView mainView) { this.mainView = mainView; }

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    public void modifyTeacher(ActionEvent event) {
        String teacher = textFieldTeacher.getText();
        String name = textFieldName.getText();
        String surname = textFieldSurname.getText();
        String birthText = textFieldBirth.getText();
        String salaryText = textFieldSalary.getText();
        String conditionText = textFieldCondition.getText();

        if(textFieldTeacher.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Teacher is not selected.");
            alert.setContentText("Enter teacher name and surname!");
            alert.showAndWait();
        }
        else if(mainView.getListTeacher().stream().noneMatch(t -> (t.getName() + " " + t.getSurname()).equalsIgnoreCase(teacher))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Teacher does not exist.");
            alert.setContentText("Enter a valid teacher name and surname!");
            alert.showAndWait();
        }
        else {
            try {
                Teacher t = mainView.getListTeacher().stream().filter(T -> (T.getName() + " " + T.getSurname()).equalsIgnoreCase(teacher)).findFirst().get();

                if (!textFieldName.getText().isEmpty()) {
                    t.name = name;
                }
                if(!textFieldSurname.getText().isEmpty()) {
                    t.surname = surname;
                }
                if(!textFieldBirth.getText().isEmpty()) {
                    t.dateOfBirth = Integer.parseInt(birthText);
                }
                if(!textFieldSalary.getText().isEmpty()) {
                    t.salary = Double.parseDouble(salaryText);
                }
                if(!textFieldCondition.getText().isEmpty()) {
                    t.condition = TeacherCondition.valueOf(conditionText.toUpperCase());
                }

                mainView.getTableTeachers().refresh();

                textFieldTeacher.clear();
                textFieldName.clear();
                textFieldSurname.clear();
                textFieldBirth.clear();
                textFieldSalary.clear();
                textFieldCondition.clear();

            }  catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Incorrect Year of birth or Salary");
                alert.setContentText("Enter valid a numeric values for Year of birth and Salary!");
                alert.showAndWait();
            } catch (IllegalArgumentException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Incorrect Teacher Condition");
                alert.setContentText("Enter valid Teacher Condition: Present, Absent, Sick or Delegation");
                alert.showAndWait();
            }
        }
    }

    public void cancel(ActionEvent event) {
        stage.close();
    }
}
