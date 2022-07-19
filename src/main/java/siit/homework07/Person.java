package siit.homework07;

import java.util.Objects;

public abstract class Person{
    private final String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Override of the toString method to return us the name parameter and age of each Person object.
     * @return Returns the name and age of every Person
     */
    @Override
    public String toString() {
        return this.name + " -> " + this.age + " years old";
    }

    /**
     * Overrides the equals method in order to mark as equals Person objects which have the same name and age. This will help us
     * assign same hash codes to equal objects.
     * @param o is a Person object to be compared with another.
     * @return Returns true if Person objects have same name and age.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age);
    }

    /**
     * Overrides the hashCode method in order to assign the same hash code to Person objects which have the same name and age.
     * @return Returns the same hash code for objects which have the same name and age.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
