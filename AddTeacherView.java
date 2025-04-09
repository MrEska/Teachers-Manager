package pau.pau_zad3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTeacherView{

    @FXML
    private TextField textFieldName, textFieldSurname, textFieldBirth, textFieldSalary, textFieldCondition;

    private MainView mainView;

    private Stage stage;

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void AddTeacher(ActionEvent event) {
        String name = textFieldName.getText();
        String surname = textFieldSurname.getText();
        String birthText = textFieldBirth.getText();
        String salaryText = textFieldSalary.getText();
        String conditionText = textFieldCondition.getText();

        if(textFieldName.getText().isEmpty() || textFieldSurname.getText().isEmpty() || textFieldBirth.getText().isEmpty() ||
                textFieldSalary.getText().isEmpty() || textFieldCondition.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Empty fields");
            alert.setContentText("Fill in all the fields!");
            alert.showAndWait();
        }
        else {
            try {
                int birth = Integer.parseInt(birthText);
                double salary = Double.parseDouble(salaryText);
                TeacherCondition condition = TeacherCondition.valueOf(conditionText.toUpperCase());

                Teacher t = new Teacher(name, surname, condition, birth, salary);
                mainView.getTable().getItems().add(t);

                textFieldName.clear();
                textFieldSurname.clear();
                textFieldBirth.clear();
                textFieldSalary.clear();
                textFieldCondition.clear();

            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Incorrect Year of birth or Salary");
                alert.setContentText("Enter valid numeric values for Year of birth and Salary!");
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

    public void Cancel(ActionEvent event) {
        stage.close();
    }
}
