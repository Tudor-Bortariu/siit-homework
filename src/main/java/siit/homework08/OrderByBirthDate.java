package siit.homework08;

import java.util.Comparator;
public class OrderByBirthDate implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge().equals(o2.getAge())){
            return o1.getId().compareTo(o2.getId());
        }
        return o1.getAge().compareTo(o2.getAge());
    }
}
