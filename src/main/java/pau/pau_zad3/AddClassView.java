package pau.pau_zad3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddClassView {

    @FXML
    private TextField textFieldName, textFieldNr;
    private MainView mainView;
    private Stage stage;

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void AddClass(ActionEvent event) {
        String groupName = textFieldName.getText();
        String maxNumTeacher = textFieldNr.getText();

        if(textFieldName.getText().isEmpty() || textFieldNr.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Empty fields");
            alert.setContentText("Fill in all the fields!");
            alert.showAndWait();
        }
        else {
            try {
                int maxNr = Integer.parseInt(maxNumTeacher);

                ClassTeacher group = new ClassTeacher(groupName, maxNr);
                mainView.getListClass().add(group);

                textFieldName.clear();
                textFieldNr.clear();

            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Incorrect Max. number.");
                alert.setContentText("Enter a valid numeric values!");
                alert.showAndWait();
            }
        }
    }

    public void Cancel(ActionEvent event) {
        stage.close();
    }
}
