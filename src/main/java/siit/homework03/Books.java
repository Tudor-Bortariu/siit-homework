package siit.homework03;

public class Books {
    private final String name;
    private final int numberOfPages;

    /**
     * This is a constructor of objects. In this case we create objects that will require two different
     * types of parameters to be entered: name and number of pages.
     * @param name is a string parameter which describes the name of the book.
     * @param numberOfPages is the total number of pages of the book.
     */
    public Books(String name, int numberOfPages) {
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return this.name + " (" +this.numberOfPages + " pages" +")";
    }
}
