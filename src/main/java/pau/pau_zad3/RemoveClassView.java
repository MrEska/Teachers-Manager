package pau.pau_zad3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RemoveClassView {

    @FXML
    private TextField textFieldName;
    private MainView mainView;
    private Stage stage;

    public void setMainView(MainView mainView) { this.mainView = mainView; }

    public  void setStage(Stage stage) { this.stage = stage; }

    @FXML
    public void removeClass(ActionEvent event) {
        String name = textFieldName.getText();

        if(textFieldName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Class is not selected.");
            alert.setContentText("Enter class name!");
            alert.showAndWait();
        }
        else if(mainView.getListClass().stream().noneMatch(c -> c.getGroupName().equalsIgnoreCase(name))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Class does not exist.");
            alert.setContentText("Enter a valid class name!");
            alert.showAndWait();
        }
        else {
            try {
                ClassTeacher group = mainView.getListClass().stream().filter(g -> g.getGroupName().equalsIgnoreCase(name)).findFirst().get();

                mainView.getListClass().remove(group);
                mainView.getTableClass().refresh();

                textFieldName.clear();

            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Cannot remove class.");
                alert.showAndWait();
            }
        }
    }

    public void cancel(ActionEvent event) {
        stage.close();
    }
}
