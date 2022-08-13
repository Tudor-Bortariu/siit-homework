package siit.homework08;

import java.util.Comparator;

public class OrderByLastName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getLastName().equals(o2.getLastName())){
            return o1.getId().compareTo(o2.getId());
        }
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
