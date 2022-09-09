package homework11.unitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class BookingDatabaseTest {

    /**
     * I establish the connection to the h2 database in a static context, so I can access it in the defined @BeforeAll method.
     */
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:test_mem");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * I made a @BeforeAll method so that I create the tables only once and Insert data into them only once before the actual tests.
     * If I'd have used the @BeforeEach annotation the method would try to create multiple tables with already existing names,
     * as the first run of a test would have created all three tables already.
     * I also created the Insert queries using the PreparedStatement.
     */
    @BeforeAll
    static void initializeConnection() {
        try {
            connection.createStatement().executeUpdate("CREATE TABLE accommodation (id integer NOT NULL UNIQUE PRIMARY KEY, type character varying(32) NOT NULL," +
                    "bed_type character varying(32) NOT NULL, " +
                    "max_guests integer NOT NULL, description character varying(512))");
            connection.createStatement().executeUpdate("CREATE TABLE room_fair (id integer NOT NULL UNIQUE PRIMARY KEY, room_value double precision NOT NULL," +
                    "season character varying(32) NOT NULL)");
            connection.createStatement().executeUpdate("CREATE TABLE accommodation_fair_relation (id integer NOT NULL UNIQUE PRIMARY KEY," +
                    "accommodation_number integer NOT NULL, room_fair_number integer NOT NULL, FOREIGN KEY (accommodation_number) REFERENCES accommodation (id)," +
                    "FOREIGN KEY (room_fair_number) REFERENCES room_fair (id))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        accommodationInsertStatement(connection, 1, "Single room", "King size", 1, "Very close to bus station.");
        roomFairInsertStatement(connection, 1, 1000.0, "Winter");
        roomRelationInsertStatement(connection, 1, 1, 1);

        accommodationInsertStatement(connection, 2, "Apartment", "Four Single Beds", 4, "Fully equipped kitchen and 4K Smart TV.");
        roomFairInsertStatement(connection, 2, 1300.0, "Summer");
        roomRelationInsertStatement(connection, 2, 2, 2);

        accommodationInsertStatement(connection, 3, "Double room", "King size", 2, "Comfortable bed and very close to the beach.");
        roomFairInsertStatement(connection, 3, 1500.0, "Summer");
        roomRelationInsertStatement(connection, 3, 3, 3);

    }

    @Test
    public void print_Query_Results_Test() {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT accommodation.type, accommodation.bed_type, room_fair.room_value FROM accommodation_fair_relation " +
                    "JOIN accommodation ON (accommodation_fair_relation.accommodation_number=accommodation.id) " +
                    "JOIN room_fair ON (accommodation_fair_relation.room_fair_number=room_fair.id)");

            while (resultSet.next()){
                System.out.println("Room type: " + resultSet.getString("type") + " | Bed Type: "
                        + resultSet.getString("bed_type") + " | Room value: " + resultSet.getDouble("room_value"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void query_Number_Of_Entries_Test() {
        int totalEntries = 0;

        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT accommodation.type, accommodation.bed_type, room_fair.room_value FROM accommodation_fair_relation " +
                    "JOIN accommodation ON (accommodation_fair_relation.accommodation_number=accommodation.id) " +
                    "JOIN room_fair ON (accommodation_fair_relation.room_fair_number=room_fair.id)");

            while (resultSet.next()){
                totalEntries += 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(3, totalEntries);
    }

    @Test
    public void query_Values_Test() {
        List<String> accommodationTypes = new ArrayList<>();
        List<Double> roomValues = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT accommodation.type, accommodation.bed_type, room_fair.room_value FROM accommodation_fair_relation " +
                    "JOIN accommodation ON (accommodation_fair_relation.accommodation_number=accommodation.id) " +
                    "JOIN room_fair ON (accommodation_fair_relation.room_fair_number=room_fair.id)");

            while (resultSet.next()){
                accommodationTypes.add(resultSet.getString("type"));
                roomValues.add(resultSet.getDouble("room_value"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(1000.0, roomValues.get(0));
        Assertions.assertEquals("Single room", accommodationTypes.get(0));

        Assertions.assertEquals(1500.0, roomValues.get(2));
        Assertions.assertEquals("Double room", accommodationTypes.get(2));
    }

    /**
     * I created separate methods for the Prepared Statements in order to make the tests easier to read.
     * @param connection is the connection to the database you want to make queries to.
     * @param id is the specific id of each entry in the table.
     * @param type is the type of accommodation.
     * @param bedType is the type of the bed.
     * @param maxGuests are the maximum number of guests allowed.
     * @param description is the description of the accommodation.
     */
    public static void accommodationInsertStatement (Connection connection, Integer id, String type, String bedType, Integer maxGuests, String description){
        try {
            PreparedStatement accommodationInsertStatement = connection.prepareStatement("INSERT INTO accommodation VALUES (? , ? , ? , ? , ?)");

            accommodationInsertStatement.setInt(1, id);
            accommodationInsertStatement.setString(2, type);
            accommodationInsertStatement.setString(3, bedType);
            accommodationInsertStatement.setInt(4, maxGuests);
            accommodationInsertStatement.setString(5, description);

            accommodationInsertStatement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void roomFairInsertStatement (Connection connection, Integer id, Double value, String season){
        try {
            PreparedStatement roomFairPreparedStatement = connection.prepareStatement("INSERT INTO room_fair VALUES (? , ? , ?)");

            roomFairPreparedStatement.setInt(1, id);
            roomFairPreparedStatement.setDouble(2, value);
            roomFairPreparedStatement.setString(3, season);

            roomFairPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void roomRelationInsertStatement (Connection connection, Integer id, Integer accommodationId, Integer roomFairId){
        try {
            PreparedStatement roomFairPreparedStatement = connection.prepareStatement("INSERT INTO accommodation_fair_relation VALUES (? , ? , ?)");

            roomFairPreparedStatement.setInt(1, id);
            roomFairPreparedStatement.setInt(2, accommodationId);
            roomFairPreparedStatement.setInt(3, roomFairId);

            roomFairPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
