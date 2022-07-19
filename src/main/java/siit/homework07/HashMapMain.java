package siit.homework07;

import java.util.*;

public class HashMapMain {
    public static void main(String[] args) {

        Person johnDoe = new Unemployed("John Doe", 28);
        Person janeDoe = new Student("Jane Doe", 21);

        HobbyAddress portugalLisbon = new HobbyAddress("Lisbon", "Portugal");
        HobbyAddress australiaSydney = new HobbyAddress("Sydney", "Australia");
        HobbyAddress franceChamonix = new HobbyAddress("Chamonix", "France");
        HobbyAddress romaniaBrasov = new HobbyAddress("Brasov", "Romania");

        List<HobbyAddress> surfingAddresses = Arrays.asList(australiaSydney, portugalLisbon);
        List<HobbyAddress> climbingAddresses = Arrays.asList(franceChamonix, romaniaBrasov);

        Hobby climbing = new Hobby("Climbing", 2, climbingAddresses);
        Hobby surfing = new Hobby("Surfing", 4, surfingAddresses);

        List<Hobby> janeDoeHobbies = List.of(climbing);
        List<Hobby> johnDoeHobbies = Arrays.asList(climbing, surfing);

        Map<Person, List<Hobby>> hobbyMap = new HashMap<>();
        hobbyMap.put(janeDoe, janeDoeHobbies);
        hobbyMap.put(johnDoe, johnDoeHobbies);

        for (Person person: hobbyMap.keySet()) {
            System.out.println(person + " " + hobbyMap.get(person));
        }
    }
}
