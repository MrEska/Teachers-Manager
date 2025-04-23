package pau.pau_zad3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MainView implements Initializable {

    @FXML
    private TableView<Teacher> tableTeachers;
    @FXML
    private TableColumn<Teacher, String> colName, colSurname;
    @FXML
    private TableColumn<Teacher, Integer> colBirth;
    @FXML
    private TableColumn<Teacher, Double> colSalary;
    @FXML
    private TableColumn<Teacher, TeacherCondition> colCondition;
    @FXML
    private TableView<ClassTeacher> tableClass;
    @FXML
    private TableColumn<ClassTeacher, String> colClassName;
    @FXML
    private TableColumn<ClassTeacher, Integer> colMaxNr;
    @FXML
    private TableColumn<ClassTeacher, Double> colFilling;
    @FXML
    private TableColumn<ClassTeacher, ObservableList<Teacher>> colTeachers;
    @FXML
    private TextField textFieldName, textFieldClassName;
    private ObservableList<Teacher> listTeacher = FXCollections.observableArrayList();
    private ObservableList<ClassTeacher> listClass = FXCollections.observableArrayList();

    public ObservableList<Teacher> getListTeacher() { return listTeacher; }

    public ObservableList<ClassTeacher> getListClass() { return listClass; }

    public TableView<Teacher> getTableTeachers() { return tableTeachers; }

    public TableView<ClassTeacher> getTableClass() { return tableClass; }

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

    @FXML
    private void removeTeacher(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RemoveTeacherView.fxml"));
            Parent root = loader.load();

            RemoveTeacherView controller = loader.getController();
            controller.setMainView(this);

            Stage stage = new Stage();
            stage.setTitle("Remove teacher");
            stage.setScene(new Scene(root));

            controller.setStage(stage);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void modifyTeacher(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyTeacherView.fxml"));
            Parent root = loader.load();

            ModifyTeacherView controller = loader.getController();
            controller.setMainView(this);

            Stage stage = new Stage();
            stage.setTitle("Modify teacher");
            stage.setScene(new Scene(root));

            controller.setStage(stage);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addClass(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddClassView.fxml"));
            Parent root = loader.load();

            AddClassView controller = loader.getController();
            controller.setMainView(this);

            Stage stage = new Stage();
            stage.setTitle("Add class");
            stage.setScene(new Scene(root));

            controller.setStage(stage);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addTeacherToClass(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTeacherToClassView.fxml"));
            Parent root = loader.load();

            AddTeacherToClassView controller = loader.getController();
            controller.setMainView(this);

            Stage stage = new Stage();
            stage.setTitle("Add teacher to class");
            stage.setScene(new Scene(root));

            controller.setStage(stage);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void removeTeacherFromClass(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RemoveTeacherFromClassView.fxml"));
            Parent root = loader.load();

            RemoveTeacherFromClassView controller = loader.getController();
            controller.setMainView(this);

            Stage stage = new Stage();
            stage.setTitle("Remove teacher from class");
            stage.setScene(new Scene(root));

            controller.setStage(stage);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void modifyClass(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyClassView.fxml"));
            Parent root = loader.load();

            ModifyClassView controller = loader.getController();
            controller.setMainView(this);

            Stage stage = new Stage();
            stage.setTitle("Modify class");
            stage.setScene(new Scene(root));

            controller.setStage(stage);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void removeClass(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RemoveClassView.fxml"));
            Parent root = loader.load();

            RemoveClassView controller = loader.getController();
            controller.setMainView(this);

            Stage stage = new Stage();
            stage.setTitle("Remove class");
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

        Teacher t1 = new Teacher("Jan", "Kowal", TeacherCondition.PRESENT, 1990, 5500);
        Teacher t2 = new Teacher("Andrzej", "Bambik", TeacherCondition.SICK, 1989, 5500);
        Teacher t3 = new Teacher("Franciszek", "Ziomek", TeacherCondition.PRESENT, 1982, 6000);
        Teacher t4 = new Teacher("Jonasz", "Sigma", TeacherCondition.DELEGATION, 1995, 58000);

        listTeacher.addAll(t1, t2, t3, t4);

        colClassName.setCellValueFactory(new PropertyValueFactory<ClassTeacher, String>("groupName"));
        colMaxNr.setCellValueFactory(new PropertyValueFactory<ClassTeacher, Integer>("MaxNumTeacher"));
        colTeachers.setCellValueFactory(new PropertyValueFactory<>("teachers"));
        colTeachers.setCellFactory(column -> new TableCell<>() {
            private final Text text = new Text();

            {
                text.wrappingWidthProperty().bind(column.widthProperty());
                setGraphic(text);
            }

            @Override
            protected void updateItem(ObservableList<Teacher> teachers, boolean empty) {
                super.updateItem(teachers, empty);
                if (empty || teachers == null || teachers.isEmpty()) {
                    text.setText(null);
                } else {
                    String names = teachers.stream().map(t -> t.getName() + " " + t.getSurname()).collect(Collectors.joining("\n"));
                    text.setText(names);
                }
            }
        });
        colFilling.setCellValueFactory(cellData -> {
            ClassTeacher ct = cellData.getValue();
            int current = ct.getTeachers().size();
            int max = ct.getMaxNumTeacher();
            double filling = max == 0 ? 0.0 : ((double) current / max) * 100;
            return new javafx.beans.property.SimpleDoubleProperty(filling).asObject();
        });

        colFilling.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Double value, boolean empty) {
                super.updateItem(value, empty);
                if (empty || value == null) {
                    setText(null);
                } else {
                    setText(String.format("%.0f%%", value));
                }
            }
        });

        ClassTeacher c1 = new ClassTeacher("Class 1", 5);
        c1.teachers.addAll(t1, t2, t3, t4);
        ClassTeacher c2 = new ClassTeacher("Class 2", 4);
        c2.teachers.addAll(t3, t4);

        listClass.addAll(c1, c2);


        FilteredList<Teacher> filteredListTeacher = new FilteredList<>(listTeacher, t -> true);

        textFieldName.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredListTeacher.setPredicate(teacher -> {
                if(newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(teacher.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if(teacher.getSurname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if(String.valueOf(teacher.getSalary()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else {
                    return false;
                }
            });
        });

        SortedList<Teacher> sortedListTeacher = new SortedList<>(filteredListTeacher);

        sortedListTeacher.comparatorProperty().bind(tableTeachers.comparatorProperty());

        tableTeachers.setItems(sortedListTeacher);

        //Class
        FilteredList<ClassTeacher> filteredListClass = new FilteredList<>(listClass, c -> true);

        textFieldClassName.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredListClass.setPredicate(group -> {
                if(newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(group.getGroupName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else {
                    return false;
                }
            });
        });

        SortedList<ClassTeacher> sortedListClass = new SortedList<>(filteredListClass);

        sortedListClass.comparatorProperty().bind(tableClass.comparatorProperty());

        tableClass.setItems(sortedListClass);
    }
}
