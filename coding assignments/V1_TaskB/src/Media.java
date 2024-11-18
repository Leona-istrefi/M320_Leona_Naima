
public class Media {
    private String title;
    private String creator;

    public Media(String title, String creator) {
        this.title = title;
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Creator: " + creator);
    }
}
