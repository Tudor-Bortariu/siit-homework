package siit.homework07;

public class HobbyAddress {
    private final String city;
    private final String country;

    public HobbyAddress(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "(" + this.city + ", " + this.country + ")";
    }
}
