package siit.homework03.userInputLibrary;

import java.util.Scanner;

public class CatalogueOperations {
    /**
     * This code asks the user to write the name of the book to add to the list and stores that value as string.
     * It asks for the number of pages of the book and stores that value as int.
     * It adds a new object to the library array list with user's given name and number of pages and prints the new array list of books.
     * @param newCatalogue defines the array list of objects you want to add the object to.
     */
    public static void addBook(LibraryCatalogue newCatalogue){
        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("Enter book name");
        String name = keyboard2.nextLine();

        Scanner keyboard3 = new Scanner(System.in);
        System.out.println("Enter number of pages");
        int numberOfPages = keyboard3.nextInt();

        Books newBook = new Books(name, numberOfPages);
        newCatalogue.addBook(newBook);
        System.out.println("Book " + newBook + " was added to library!");
        System.out.println("The new library list is: " + newCatalogue.getCatalogue());
    }

    /**
     * This code asks the user to write the array list position number of the book he/she wants to delete and removes the object from the list.
     * It then prints the new array list.
     * @param newCatalogue defines the array list of objects you want to remove the object from.
     */
    public static void deleteBook (LibraryCatalogue newCatalogue){
        Scanner delete = new Scanner(System.in);
        System.out.println("Enter book number");
        int bookNumber = delete.nextInt();

        newCatalogue.removeBookFromPosition(bookNumber);
        System.out.println(newCatalogue.getCatalogue());
    }
}
