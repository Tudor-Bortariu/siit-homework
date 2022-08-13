package siit.homework08;

import java.util.*;
public class StudentSet {
    /**
     * I define a constant that will store every student added.
     */
    private static final Set<Student> STUDENT_SET = new HashSet<>();

    /**
     * This method allows a student instance to be added to the Student Set created previously.
     * @param student is the student instance to be added.
     */
    public void addStudent(Student student){
        STUDENT_SET.add(student);
    }

    /**
     * This method takes an ID as parameter and searches the Student Set to see if any student has that ID. If the iteration finds a match
     * it deletes that instance from the Set. If a match is not found, a console message will be printed.
     * @param id is the ID of the student you want to be removed.
     */
    public void deleteStudent(String id){
        boolean studentFound = false;
        for (Student student : STUDENT_SET) {
            if (student.getId().equals(id)) {
                STUDENT_SET.remove(student);
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Student with ID " + id + " does not exist.");
        }
    }

    /**
     * This method will iterate through the Student Set and print every student stored in it.
     */
    public void listStudents(){
        for (Student student: STUDENT_SET) {
            System.out.println(student);
        }
    }

    /**
     * This method takes an Age value as parameter and checks to see if the Student Set stores any instances with that exact age.
     * If there is any matches, those students names will be printed. If not, another message will be printed.
     * @param age is age you want to search the students by.
     */
    public void retrieveStudents(Integer age) {
        boolean studentFound = false;
        for (Student student : STUDENT_SET) {
            if (student.getAge().equals(age)){
                System.out.println(student);
                studentFound = true;
            }
        }
        if (!studentFound){
            System.out.println("No students of specified age were found.");
        }
    }

    /**
     * This method creates a new Tree Set with date of birth comparator and prints the student instances stored in the previously created
     * Student Set in order, by date of birth. It takes the Student's age and orders the students in natural order by their ages. So, in this case,
     * the younger students will be printed first.
     */
    public void listStudentsByBirthDate(){
        OrderByBirthDate orderByBirthDate = new OrderByBirthDate();
        Set<Student> studentSet = new TreeSet<>(orderByBirthDate);
        studentSet.addAll(STUDENT_SET);

        for (Student student:studentSet) {
            System.out.println(student);
        }
    }
    /**
     * This method creates a new Tree Set with last name comparator and prints the student instances stored in the previously created
     * Student Set in natural order, by last name.
     */
    public void listStudentsByLastName(){
        OrderByLastName orderByLastName = new OrderByLastName();
        Set<Student> studentSet = new TreeSet<>(orderByLastName);
        studentSet.addAll(STUDENT_SET);

        for (Student student:studentSet) {
            System.out.println(student);
        }
    }
}
