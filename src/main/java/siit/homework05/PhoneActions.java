package siit.homework05;

public interface PhoneActions {
    void addContact(int index, String phoneNumber, String firstName, String lastName);
    void listContacts();
    void sendMessage(String phoneNumber, String message);
    void listMessages(String phoneNumber);
    void call(String phoneNumber);
    void seeCallHistory();
    void rechargePhone();
    void checkBatteryLifetime();
}
