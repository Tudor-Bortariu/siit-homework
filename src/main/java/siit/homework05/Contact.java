package siit.homework05;

public class Contact {
    private int contactIndex;
    private String telephoneNumber;
    private String firstName;
    private String secondName;

    public Contact(int contactIndex, String telephoneNumber, String firstName, String secondName) {
        this.contactIndex = contactIndex;
        this.telephoneNumber = telephoneNumber;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getContactIndex() {
        return contactIndex;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return this.getContactIndex() + ". " + this.getFirstName() + " " + this.getSecondName() + " - " + this.getTelephoneNumber();
    }
}
