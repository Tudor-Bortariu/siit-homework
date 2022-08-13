package siit.homework08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Objects;

public class Student{
    private static final Logger LOGGER = LogManager.getLogger();
    private final String firstName;
    private final String lastName;
    private final Integer dateOfBirth;
    private final String gender;
    private final String id;
    private Integer age;

    /**
     * In this constructor I implemented try-catch in order to throw exceptions if specific conditions are not met by the introduced parameters. In this constructor I also implemented
     * try catch because we have no class with main method to make exception handling there.
     * @param firstName throws exception if the field is empty or has only white spaces.
     * @param lastName throws exception if the field is empty or has only white spaces.
     * @param dateOfBirth throws exception if the year is less than 1900 and bigger than the current year - 18.
     * @param gender has to be only male or female (ignoring cases).
     * @param id throws exception if parameter is empty or has only empty spaces and if it does not have 13 characters.
     */
    public Student(String firstName, String lastName, Integer dateOfBirth, String gender, String id){
        try {
            if (firstName.isBlank()) {
                throw new IllegalArgumentException("First Name field cannot be empty.");
            } else if(!firstName.matches("([a-zA-Z]-*\\s*)+")){
                throw new IllegalArgumentException("Illegal format for First Name.");
            }else{
                this.firstName = firstName;
            }
            if (lastName.isBlank()) {
                throw new IllegalArgumentException("Last Name field cannot be empty.");
            } else if(!lastName.matches("([a-zA-Z]-*\\s*)+")){
                throw new IllegalArgumentException("Illegal format for Last Name.");
            } else {
                this.lastName = lastName;
            }
            int tempYear = LocalDate.now().getYear() - 18;
            if (dateOfBirth < 1900 || dateOfBirth > tempYear) {
                throw new IllegalArgumentException("Date of birth must be higher than 1900 and less than current year - 18.");
            } else {
                this.dateOfBirth = dateOfBirth;
            }
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                this.gender = gender;
            } else {
                throw new IllegalArgumentException("Gender must be Male or Female.");
            }
            if (id.isBlank()) {
                throw new IllegalArgumentException("ID cannot be empty.");
            } else if(!id.matches("\\d{13}")){
                throw new IllegalArgumentException("ID needs to have exactly 13 characters. Only DIGITS are allowed.");
            }else{
                this.id = id;
            }
        }catch (IllegalArgumentException exception){
            LOGGER.error("Illegal Argument Exception. " + exception.getMessage());
            throw new IllegalArgumentException (exception.getMessage());
        }
        age = LocalDate.now().getYear() - dateOfBirth;
    }

    public String getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * I override equals method so Students with same IDs are considered equals because the ID should be unique for every single person.
     * @param o is object you want to compare yours to.
     * @return returns true if objects have same ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    /**
     * I override hashCode in order to make it unable for two students with same ID to be added in a Set.
     * @return returns same hash code for objects which have same ID parameter.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
