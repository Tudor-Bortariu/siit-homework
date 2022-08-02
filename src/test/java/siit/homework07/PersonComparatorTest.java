package siit.homework07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonComparatorTest {
    PersonNameComparator personNameComparator = new PersonNameComparator();
    PersonAgeComparator personAgeComparator = new PersonAgeComparator();
    Person zahariaAndrei = new Unemployed("Zaharia Andrei", 28);
    Person ababeiMihaela = new Employed("Ababei Mihaela", 32);
    Person zahariaAndrei2 = new Student("Zaharia Andrei", 28);

    @Test
    public void person_Name_Comparator_Test() {
        int result = personNameComparator.compare(ababeiMihaela, zahariaAndrei);

        Assertions.assertTrue(result < 0,ababeiMihaela.getName() + " expected to be less than " + zahariaAndrei.getName());
    }

    @Test
    public void person_Equal_Name_Comparator_Test() {
        int result = personNameComparator.compare(zahariaAndrei2, zahariaAndrei);

        Assertions.assertTrue(result == 0,zahariaAndrei2.getName() + " expected to be equal to " + zahariaAndrei.getName());
    }

    @Test
    public void person_Smaller_Age_Comparator_Test() {
        int result = personAgeComparator.compare(zahariaAndrei, ababeiMihaela);

        Assertions.assertTrue(result < 0,zahariaAndrei.getAge() + " expected to be less than " + ababeiMihaela.getAge());
    }

    @Test
    public void person_Bigger_Age_Comparator_Test() {
        int result = personAgeComparator.compare(ababeiMihaela, zahariaAndrei);

        Assertions.assertTrue(result > 0,ababeiMihaela.getAge() + " expected to be greater than " + zahariaAndrei.getAge());
    }

    @Test
    public void person_Equal_Age_Comparator_Test() {
        int result = personAgeComparator.compare(zahariaAndrei2, zahariaAndrei);

        Assertions.assertTrue(result == 0, zahariaAndrei2.getAge() + " expected to be equal to " + zahariaAndrei.getAge());
    }
}