package siit.homework03.userInputLibrary;

public class Novels extends Books {
    private final String type;

    /**
     * This is a constructor of a new type of object that extends the Books class. In this case the object will inherit the name and number of pages
     * parameters and will also require a type parameter besides the initial ones.
     * @param name is a string parameter which describes the name of the novel.
     * @param numberOfPages is the total number of pages of the novel.
     * @param type is a string parameter describing the type of the novel.
     */
    public Novels(String name, int numberOfPages, String type) {
        super(name, numberOfPages);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
