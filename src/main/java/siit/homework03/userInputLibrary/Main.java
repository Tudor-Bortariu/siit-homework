package siit.homework03.userInputLibrary;

public class Main {

    public static void main(String[] args) {

        LibraryCatalogue newCatalogue = new LibraryCatalogue();

        Books annaKarenina = new Novels("Anna Karenina", 864, "Fiction");
        Books joyful = new ArtAlbums("Joyful", 57, "Photographic");
        Books theGreatGatsby = new Novels("The Great Gatsby", 532, "Realism");
        Books donQuixote = new Novels("Don Quixote", 1077, "Fiction");
        Books earth = new ArtAlbums("Earth", 322, "Photographic");

        newCatalogue.addBook(annaKarenina);
        newCatalogue.addBook(joyful);
        newCatalogue.addBook(theGreatGatsby);
        newCatalogue.addBook(donQuixote);
        newCatalogue.addBook(earth);

        newCatalogue.deleteBook(annaKarenina);

        EnterCommand.enterCommand(newCatalogue);
    }
}
