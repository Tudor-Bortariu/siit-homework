package siit.homework03.userInputLibrary;

public class ArtAlbums extends Books{
    private final String paperQuality;

    /**
     * This is a constructor of a new type of object that extends the Books class. In this case the object will inherit the name and number of pages
     * parameters and will also require a paper quality parameter besides the initial ones.
     * @param name is a string parameter which describes the name of the novel album.
     * @param numberOfPages is the total number of pages of the album.
     * @param paperQuality is a string parameter describing the paper type of the album.
     */
    public ArtAlbums(String name, int numberOfPages, String paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return paperQuality;
    }
}
