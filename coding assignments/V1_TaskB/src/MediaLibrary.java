// Main class to demonstrate the functionality
public class MediaLibrary {
    public static void main(String[] args) {
        // Create media objects
        DVD dvd = new DVD("Inception", "Christopher Nolan", 148);
        CD cd = new CD("Abbey Road", "The Beatles", 17);
        Book book = new Book("1984", "George Orwell", "978-0451524935");

        // Add objects to an array
        Media[] mediaLibrary = {dvd, cd, book};

        // Display details of each media
        System.out.println("Media Library:");
        for (Media media : mediaLibrary) {
            media.displayDetails();
            System.out.println();
        }

        // Search for a title
        String searchTitle = "1984";
        System.out.println("Searching for title: " + searchTitle);
        boolean found = false;
        for (Media media : mediaLibrary) {
            if (media.getTitle().equalsIgnoreCase(searchTitle)) {
                System.out.println("Found: ");
                media.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Title not found in the library.");
        }
    }
}

