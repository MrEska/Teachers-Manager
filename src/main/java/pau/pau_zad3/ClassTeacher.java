package pau.pau_zad3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

public class ClassTeacher {
    String groupName;
    ObservableList<Teacher> teachers;
    int MaxNumTeacher;

    ClassTeacher(String groupName, int MaxNumTeacher) {
        this.groupName = groupName;
        this.teachers = FXCollections.observableArrayList();
        this.MaxNumTeacher = MaxNumTeacher;
    }

    public String getGroupName() { return groupName; }

    public int getMaxNumTeacher() { return MaxNumTeacher; }

    public List<Teacher> getTeachers() { return teachers; }
}