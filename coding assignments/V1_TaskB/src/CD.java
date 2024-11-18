
public class CD extends Media {
    private int tracks;

    public CD(String title, String creator, int tracks) {
        super(title, creator);
        this.tracks = tracks;
    }

    public int getTracks() {
        return tracks;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Tracks: " + tracks);
    }
}

