package pau.pau_zad3;

import java.util.Comparator;

public abstract class CompareSalary implements Comparator<Teacher> {
    public abstract int compare(Teacher t1, Teacher t2);
}
