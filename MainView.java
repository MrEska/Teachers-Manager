package pau.pau_zad3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainView implements Initializable {

    @FXML
    private Button addTeacherButton, addClassButton;

    @FXML
    private TableView<Teacher> table;

    @FXML
    private TableColumn<Teacher, String> colName, colSurname;

    @FXML
    private TableColumn<Teacher, Integer> colBirth;

    @FXML
    private TableColumn<Teacher, Double> colSalary;

    @FXML
    private TableColumn<Teacher, TeacherCondition> colCondition;

    public TableView<Teacher> getTable() { return table; }

    @FXML
    private void addTeacher(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTeacherView.fxml"));
            Parent root = loader.load();

            AddTeacherView controller = loader.getController();
            controller.setMainView(this);

            Stage stage = new Stage();
            stage.setTitle("Add teacher");
            stage.setScene(new Scene(root));

            controller.setStage(stage);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        colSurname.setCellValueFactory(new PropertyValueFactory<Teacher, String>("surname"));
        colBirth.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("birth"));
        colSalary.setCellValueFactory(new PropertyValueFactory<Teacher, Double>("salary"));
        colCondition.setCellValueFactory(new PropertyValueFactory<Teacher, TeacherCondition>("condition"));

        table.getItems().add(new Teacher("Jan", "Kowal", TeacherCondition.PRESENT, 1990, 5500));
        table.getItems().add(new Teacher("Andrzej", "Bambik", TeacherCondition.SICK, 1989, 5500));
    }
}
