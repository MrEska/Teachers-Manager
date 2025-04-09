package pau.pau_zad3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ClassContainer {
    Map<String, ClassTeacher> groups;

    ClassContainer() {
        groups = new HashMap<>();
    }

    void addClass(String groupName, int size) {
        groups.put(groupName, new ClassTeacher(groupName, size));
    }

    void removeClass(String groupName) {
        groups.remove(groupName);
    }

    List<Map<String, ClassTeacher>> findEmpty() {
        List<Map<String, ClassTeacher>> empty = new ArrayList<>();

        for(Map.Entry<String, ClassTeacher> group : groups.entrySet()) {
            if(group.getValue().teachers.isEmpty()) {
                Map<String, ClassTeacher> emptyGroup = new HashMap<>();
                emptyGroup.put(group.getKey(), group.getValue());
                empty.add(emptyGroup);
            }
        }
        return empty;
    }

    void summary() {
        for(Map.Entry<String, ClassTeacher> group : groups.entrySet()) {
            double size = group.getValue().teachers.size();
            double max = group.getValue().MaxNumTeacher;
            double filling = size / max * 100;
            System.out.println("Group's name: " + group.getKey() + "\nFilling: " + filling + "%\n");
        }
    }
}
