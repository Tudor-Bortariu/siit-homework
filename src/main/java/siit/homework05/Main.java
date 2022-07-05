package siit.homework05;

public class Main {
    public static void main(String[] args) {
        //Phone phone = new Samsung();

        Phone iPhone11 = new Iphone11ProMax("12566545858", "White", "Glass", 36);

        iPhone11.addContact(1, "0786594235", "John", "Doe");
        iPhone11.addContact(2, "0756254898", "Jane", "Doe");
        iPhone11.listContacts();

        iPhone11.sendMessage("0786594235", "This is the first message");
        iPhone11.sendMessage("0786594235", "This is the second message");
        iPhone11.listMessages("0786594235");

        iPhone11.sendMessage("0756254898", "Message to another contact");
        iPhone11.listMessages("0756254898");

        iPhone11.call("0756254898");
        iPhone11.seeCallHistory();

        iPhone11.checkBatteryLifetime();
        iPhone11.rechargePhone();
    }
}
