package pau.pau_zad3;

public class Teacher implements Comparable<Teacher> {
    String name, surname;
    TeacherCondition condition;
    int dateOfBirth;
    double salary;

    Teacher(String name, String surname, TeacherCondition cond, int dof, double salary) {
        this.name = name;
        this.surname = surname;
        condition = cond;
        dateOfBirth = dof;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getBirth() {
        return dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public TeacherCondition getCondition() {
        return condition;
    }

    void printing() {
        System.out.println("Name: " + name + "\nSurname: " + surname + "\nDate of birth: " + dateOfBirth + "\nSalary: " + salary + "\nCondition: " + condition);
    }

    public int compareTo(Teacher t) {
        int compSurname = surname.compareTo(t.surname);

        if(compSurname == 0) {
            return name.compareTo(t.name);
        }
        else {
            return compSurname;
        }
    }
}
