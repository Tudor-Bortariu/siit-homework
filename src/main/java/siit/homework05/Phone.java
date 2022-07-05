package siit.homework05;

import java.util.ArrayList;

public abstract class Phone implements PhoneActions{
    private String imei;
    private String color;
    private String material;
    private int batteryLife;
    private int batteryRecharge;
    private String[] messageHistory;
    private String[] callHistory;

    public Phone(String imei, String color, String material, int batteryLife) {
        setImei(imei);
        this.color = color;
        this.material = material;
        this.batteryLife = batteryLife;
        this.batteryRecharge = this.batteryLife;
        this.messageHistory = new String[0];
        this.callHistory = new String[0];
    }

    static ArrayList<String> existingImeiList = new ArrayList<>();

    /**
     * With this setter we create an array list that will store the imei's from all the created Phone instances.
     * We also check if the newly created imei already is in the list and if it is, we throw an exception at runtime.
     * In this way we make sure each imei number is unique.
     * @param imei is the unique identify number of every phone.
     */
    public void setImei(String imei) {
        if (existingImeiList.contains(imei)){
            throw new RuntimeException("Imei " + imei + " already exists! Imei has to be unique!");
        }else{
            this.imei = imei;
            existingImeiList.add(this.imei);
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    static ArrayList<Contact> contactsList = new ArrayList<>();

    /**
     * We create a new object type that will store contacts with the specified parameters. We also create a new array list
     * that stores all the created contacts. We use the addContact method to add a new contact to the list. We read those parameters
     * from the method instance and we build an instance of the Contact class with those parameters.
     * @param index is the index of the contact. This will help us also establish the position of this object instance in the array list
     *              if we will need to modify the contact details.
     * @param phoneNumber is the phone number of that specific contact.
     * @param firstName is the first name of the contact.
     * @param lastName is the last name of the contact.
     */
    @Override
    public void addContact(int index, String phoneNumber, String firstName, String lastName){
        Contact newContact = new Contact(index, phoneNumber, firstName, lastName);
        contactsList.add(newContact);
    }

    @Override
    public void listContacts() {
        System.out.println(contactsList);
    }

    public void setMessageHistory(String[] messageHistory) {
        this.messageHistory = messageHistory;
    }

    /**
     * With this method we check if the message sent has more than 500 characters and we send a System out stating that the message
     * is too big. If the message has less than 500 characters it decreases the battery lifetime by 1 hour. We create a new array of
     * Strings with length greater by 1 than the messageHistory array. If the messageHistory array is empty we add the new message to it.
     * If the array is not empty we make a for in order to get through each element of the messageHistory array and add it to the bigger
     * array. We also add the message that's being sent to the last position of the bigger array.
     * @param phoneNumber is the number you want to send a message to. This number helps to identify the messages sent to a specific
     *                    number.
     * @param message is the content of the message you want to send.
     */
    @Override
    public void sendMessage(String phoneNumber, String message) {
        if (message.length() > 500) {
            System.out.println("Message is too big! You can use max 500 characters!");
        } else {
            setBatteryLife(this.batteryLife - 1);
            String[] tempArray = new String[this.messageHistory.length + 1];
            if (this.messageHistory.length == 0) {
                tempArray[0] = phoneNumber + " " + message;
                setMessageHistory(tempArray);
            } else if (this.messageHistory.length == 1) {
                tempArray[0] = this.messageHistory[0];
                tempArray[1] = phoneNumber + " " + message;
                setMessageHistory(tempArray);
            } else {
                for (int i = 0; i < this.messageHistory.length; i++) {
                    tempArray[i] = this.messageHistory[i];
                }
                    tempArray[this.messageHistory.length] = phoneNumber + " " + message;
                    setMessageHistory(tempArray);
                }
            }
        }

    /**
     * With this method we check if there are any messages stored for a specific number in the messageHistory array from the object instance.
     * To do this we create a substring for the first 10 characters of every String stored in the Array. As we designed this, the first 10 characters
     * represent the phone number. If the number is found through the messages, it shows that specific message.
     * @param phoneNumber is the phone number you want to check if you sent messages to.
     */
        @Override
    public void listMessages(String phoneNumber) {
        System.out.println("Message history for number " + phoneNumber);
        for (String s : messageHistory) {
            String messagesFromNumber = s.substring(0, 10);
            if (messagesFromNumber.equalsIgnoreCase(phoneNumber)) {
                System.out.println(s);
            }
        }
    }

    public void setCallHistory(String[] callHistory) {
        this.callHistory = callHistory;
    }

    /**
     * With this method we decrease the life of the battery by 2 each time a call is made. We create a new array of
     * Strings with length greater by 1 than the callHistory array. If the callHistory array is empty we add the called phone number to it.
     * If the array is not empty we make a loop in order to get through each element of the callHistory array and add it to the bigger
     * array. We also add the call that's being made to the last position of the bigger array.
     * At the end we make a loop to get through the list of available contacts and see if the phone number is already in the phone's
     * list. If the number is there, the first and last name will appear for that contact.
     * @param phoneNumber is the phone number you want to call.
     */
        @Override
    public void call(String phoneNumber) {
        setBatteryLife(this.batteryLife - 2);
        String[] tempArray = new String[this.callHistory.length + 1];
            if (this.callHistory.length == 0) {
                tempArray[0] = phoneNumber;
                setCallHistory(tempArray);
            } else if (this.callHistory.length == 1) {
                tempArray[0] = this.callHistory[0];
                tempArray[1] = phoneNumber;
                setCallHistory(tempArray);
            } else {
                for (int i = 0; i < this.callHistory.length; i++) {
                    tempArray[i] = this.callHistory[i];
                }
                tempArray[this.callHistory.length] = phoneNumber;
                setCallHistory(tempArray);
            }
            for (Contact c: contactsList) {
                if (c.getTelephoneNumber().equalsIgnoreCase(phoneNumber)){
                    System.out.println("Calling " + c.getFirstName() + " " + c.getSecondName());
                }
            }
    }

    @Override
    public void seeCallHistory() {
        System.out.println("Call history: ");
        for (String s : callHistory) {
            System.out.println(s);
        }
    }

    @Override
    public void rechargePhone() {
        setBatteryLife(batteryRecharge);
    }

    @Override
    public void checkBatteryLifetime() {
        System.out.println(this.getBatteryLife());
    }
}
