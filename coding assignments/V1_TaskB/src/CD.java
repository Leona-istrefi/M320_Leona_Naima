
public class CD extends Media {
    private int tracks;

    public CD(String title, int year, float price, int tracks) {
        super(title, year, price);
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

