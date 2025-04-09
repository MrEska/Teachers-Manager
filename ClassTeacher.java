package pau.pau_zad3;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ClassTeacher {
    String groupName;
    List<Teacher> teachers;
    int MaxNumTeacher;

    ClassTeacher(String groupName, int MaxNumTeacher) {
        this.groupName = groupName;
        this.teachers = new ArrayList<>();
        this.MaxNumTeacher = MaxNumTeacher;
    }

    void addTeacher(Teacher t) {
        if(teachers.size() == MaxNumTeacher) {
            System.out.println("Group is full");
            return;
        }
        for(Teacher teacher : teachers) {
            if(t.surname.equals(teacher.surname) && t.name.equals(teacher.name)) {
                System.out.println("Teacher is already added");
                return;
            }
        }
        teachers.add(t);
    }

    void addSalary(Teacher t, double s) {
        t.salary += s;
    }

    void removeTeacher(Teacher t) {
        teachers.remove(t);
    }

    void changeCondition(Teacher t, TeacherCondition cond) {
        t.condition = cond;
    }

    Teacher search(String sname) {
        for(Teacher teacher : teachers) {
            if(teacher.getSurname().compareToIgnoreCase(sname) == 0) {
                return teacher;
            }
        }
        return null;
    }

    List<Teacher> searchPartial(String name) {
        List<Teacher> matchedTeachers = new ArrayList<>();
        int size = name.length();

        for(Teacher teacher : teachers) {
            for(int i = 0; i < size; i++) {
                if(i >= teacher.surname.length() || teacher.surname.charAt(i) != name.charAt(i)) {
                    break;
                }
                if (i == size - 1) {
                    matchedTeachers.add(teacher);
                }
            }
        }
        return matchedTeachers;
    }

    int countByCondition(String cond) {
        int count = 0;

        for(Teacher teacher : teachers) {
            if(teacher.condition.toString().equals(cond)) {
                count++;
            }
        }
        return count;
    }

    void summary() {
        int nr = 1;
        for(Teacher teacher : teachers) {
            System.out.println(nr + ". " + "Name: " + teacher.name + "\nSurname: " + teacher.surname + "\nDate of birth: " + teacher.dateOfBirth + "\nSalary: " + teacher.salary +
                    "\nCondition: " + teacher.condition + "\n");
            nr++;
        }
    }

    List<Teacher> sortByName() {
        Collections.sort(teachers);
        return teachers;
    }

    List<Teacher> sortBySalary() {
        Collections.sort(teachers, new CompareSalary() {
            @Override
            public int compare(Teacher t2, Teacher t1) {
                return Double.compare(t1.salary, t2.salary);
            }
        });
        return teachers;
    }

    Teacher max() {
        return Collections.max(teachers, new CompareSalary() {
            @Override
            public int compare(Teacher t1, Teacher t2) {
                return Double.compare(t1.salary, t2.salary);
            }
        });
    }
}