package siit.homework07;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {
    /**
     * Overrides the method in order to compare Person objects and order them by age in natural order.
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return Returns positive to order objects in natural order.
     */
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
