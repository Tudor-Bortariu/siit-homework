package siit.homework03.userInputLibrary;

import java.util.Scanner;

public class EnterCommand {
    /**
     * This code asks the user for an input, reads that input and compares it with a specific command line.
     * If the input of the user is "print", the method returns the objects from a specific array list of objects.
     * If the input is "add" the method will call the addBook method to add a new book to the list.
     * If the input is "delete" the method will call the deleteBook method to remove an object from the array list.
     * @param newCatalogue is the name of the array list of objects you want the code to return.
     */
    public static void enterCommand(LibraryCatalogue newCatalogue) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter command PRINT, ADD or DELETE");
        String command = keyboard.next();

        if (command.equals("Print") || command.equals("print") || command.equals("PRINT")) {
            System.out.println(newCatalogue.getCatalogue());
        } else if (command.equals("Add") || command.equals("add") || command.equals("ADD")) {
            CatalogueOperations.addBook(newCatalogue);
        } else if(command.equals("Delete") || command.equals("delete") || command.equals("DELETE")){
            CatalogueOperations.deleteBook(newCatalogue);
        } else{
            System.out.println("Command not recognised. Please try again!");
        }
    }
}
