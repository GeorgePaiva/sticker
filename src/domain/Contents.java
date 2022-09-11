package domain;

/**
 * @author georgepaiva.dev
 */
public class Contents {
    private final String title;
    private final String image;

    public Contents(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

}
