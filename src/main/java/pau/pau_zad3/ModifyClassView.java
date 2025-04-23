package pau.pau_zad3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifyClassView {

    @FXML
    private TextField textFieldClass, textFieldName, textFieldNr;
    private MainView mainView;
    private Stage stage;

    public void setMainView(MainView mainView) { this.mainView = mainView; }

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    public void modifyClass(ActionEvent event) {
        String group = textFieldClass.getText();
        String name = textFieldName.getText();
        String nr = textFieldNr.getText();

        if(textFieldClass.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Class is not selected.");
            alert.setContentText("Enter class name!");
            alert.showAndWait();
        }
        else if(mainView.getListClass().stream().noneMatch(g -> g.getGroupName().equalsIgnoreCase(group))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Class does not exist.");
            alert.setContentText("Enter a valid class name!");
            alert.showAndWait();
        }
        else {
            try {
                ClassTeacher c = mainView.getListClass().stream().filter(gr -> gr.getGroupName().equalsIgnoreCase(group)).findFirst().get();

                if(!textFieldName.getText().isEmpty()) {
                    c.groupName = name;
                }
                if(!textFieldNr.getText().isEmpty()) {
                    int number = Integer.parseInt(nr);

                    if(number < c.teachers.size()) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information");
                        alert.setHeaderText("Too many teachers in the class.");
                        alert.setContentText("Delete teachers or add space to class first!");
                        alert.showAndWait();
                    }
                    else {
                        c.MaxNumTeacher = number;
                    }
                }

                mainView.getTableClass().refresh();

                textFieldClass.clear();
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

    public void cancel(ActionEvent event) {
        stage.close();
    }
}
