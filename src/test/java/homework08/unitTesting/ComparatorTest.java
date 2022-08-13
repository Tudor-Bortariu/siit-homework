package homework08.unitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import siit.homework08.OrderByBirthDate;
import siit.homework08.OrderByLastName;
import siit.homework08.Student;

public class ComparatorTest {
    OrderByBirthDate orderByBirthDate = new OrderByBirthDate();
    OrderByLastName orderByLastName = new OrderByLastName();

    Student johnDoe = new Student("John", "Doe", 1990, "MALE", "196584512455");
    Student janeJoe = new Student("Jane", "Joe", 1995, "female", "2966215587841");

    @Test
    public void birth_Date_Comparator_Test() {
        int result = orderByBirthDate.compare(johnDoe, janeJoe);

        Assertions.assertTrue(result > 0,"Person with age " + johnDoe.getAge() + " expected to be older than person with age " + janeJoe.getAge());
    }

    @Test
    public void last_Name_Comparator_Test() {
        int result = orderByLastName.compare(johnDoe, janeJoe);

        Assertions.assertTrue(result < 0,"Person with last name " + johnDoe.getLastName() + " expected to appear before " + janeJoe.getLastName() + " in alphabetical order");
    }
}
