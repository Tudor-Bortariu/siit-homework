package siit.homework03.userInputLibrary;

import java.util.ArrayList;

public class LibraryCatalogue {

    ArrayList<Books> catalogue = new ArrayList<>();

    public ArrayList<Books> getCatalogue() {
        return catalogue;
    }

    /**
     * This code ads a book object to an array list.
     * @param book defines the object you want to add to the array list.
     */
    public void addBook (Books book){
        catalogue.add(book);
    }

    /**
     * This code removes a book object from an array list.
     * @param book defines the object you want to remove from the array list.
     */
    public void deleteBook (Books book){
        catalogue.remove(book);
    }

    public void removeBookFromPosition (int x){
        catalogue.remove(x);
    }
}
