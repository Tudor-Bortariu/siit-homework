package siit.homework12;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int lastNameCompare = p1.getLastName().compareTo(p2.getLastName());
        int firstNameCompare = p1.getFirstName().compareTo(p2.getFirstName());
        if(lastNameCompare == 0){
            return firstNameCompare;
        }else{
            return lastNameCompare;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
