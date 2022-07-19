package siit.homework07;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {
        Person johnDoe = new Unemployed("John Doe", 28);
        Person janeDoe = new Student("Jane Doe", 21);
        Employed jimmyStones = new Employed("Jimmy Stones", 32);

        Set<Person> personSet1 = new TreeSet<>(new PersonNameComparator());
        personSet1.add(johnDoe);
        personSet1.add(janeDoe);
        personSet1.add(jimmyStones);

        Iterator<Person> personsIterator1 = personSet1.iterator();
        while (personsIterator1.hasNext()){
            System.out.println(personsIterator1.next());
        }

        Set<Person> personSet2 = new TreeSet<>(new PersonAgeComparator());
        personSet2.add(johnDoe);
        personSet2.add(janeDoe);
        personSet2.add(jimmyStones);

        Iterator<Person> personsIterator2 = personSet2.iterator();
        while (personsIterator2.hasNext()){
            System.out.println(personsIterator2.next());
        }
    }
}
