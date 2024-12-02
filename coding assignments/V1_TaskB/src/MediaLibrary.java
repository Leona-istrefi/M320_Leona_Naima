import java.util.ArrayList;
import java.util.Scanner;

// Main class to demonstrate the functionality
public class MediaLibrary {
    private static ArrayList<Media> mediaLibrary = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Prepopulate the library with some media items
        mediaLibrary.add(new DVD("Inception", 2014, 14.99f, 148));
        mediaLibrary.add(new CD("Abbey Road", 2003, 17.5f, 4));
        mediaLibrary.add(new Book("1984", 2000, 19.99f, "978-0451524935"));

        boolean running = true;

        while (running) {
            System.out.println("\nMedia Library");
            System.out.println("1. Display all media");
            System.out.println("2. Search for a media item");
            System.out.println("3. Add a new media item");
            System.out.println("4. Remove a media item");
            System.out.println("5. Change the price of a media item");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> displayAllMedia();
                case 2 -> searchMedia();
                case 3 -> addMedia();
                case 4 -> removeMedia();
                case 5 -> changeMediaPrice();
                case 6 -> {
                    running = false;
                    System.out.println("Exiting the Media Library. Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to display all media items
    private static void displayAllMedia() {
        if (mediaLibrary.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("\nMedia Library Contents:");
            for (Media media : mediaLibrary) {
                media.displayDetails();
                System.out.println();
            }
        }
    }

    // Method to search for a media item by title
    private static void searchMedia() {
        System.out.print("Enter the title to search for: ");
        String searchTitle = scanner.nextLine();
        boolean found = false;

        for (Media media : mediaLibrary) {
            if (media.getTitle().equalsIgnoreCase(searchTitle)) {
                System.out.println("Found:");
                media.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Media item not found.");
        }
    }

    // Method to add a new media item
    private static void addMedia() {
        System.out.println("Select the type of media to add:");
        System.out.println("1. DVD");
        System.out.println("2. CD");
        System.out.println("3. Book");
        System.out.print("Your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> {
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter year: ");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter price: ");
                float price = Float.parseFloat(scanner.nextLine());
                System.out.print("Enter runtime (in minutes): ");
                int runtime = Integer.parseInt(scanner.nextLine());
                mediaLibrary.add(new DVD(title, year, price, runtime));
                System.out.println("DVD added successfully!");
            }
            case 2 -> {
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter year: ");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter price: ");
                float price = Float.parseFloat(scanner.nextLine());
                System.out.print("Enter number of tracks: ");
                int tracks = Integer.parseInt(scanner.nextLine());
                mediaLibrary.add(new CD(title, year, price, tracks));
                System.out.println("CD added successfully!");
            }
            case 3 -> {
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter year: ");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter price: ");
                float price = Float.parseFloat(scanner.nextLine());
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                mediaLibrary.add(new Book(title, year, price, isbn));
                System.out.println("Book added successfully!");
            }
            default -> System.out.println("Invalid option. No media added.");
        }
    }

    // Method to remove a media item by title
    private static void removeMedia() {
        System.out.print("Enter the title of the media item to remove: ");
        String titleToRemove = scanner.nextLine();
        boolean removed = mediaLibrary.removeIf(media -> media.getTitle().equalsIgnoreCase(titleToRemove));

        if (removed) {
            System.out.println("Media item removed successfully!");
        } else {
            System.out.println("Media item not found.");
        }
    }

    // Method to change the price of a media item
    private static void changeMediaPrice() {
        if (mediaLibrary.isEmpty()) {
            System.out.println("The library is empty. No prices can be updated.");
            return;
        }

        System.out.println("Select a media item to change the price:");
        for (int i = 0; i < mediaLibrary.size(); i++) {
            System.out.println((i + 1) + ". " + mediaLibrary.get(i).getTitle());
        }

        System.out.print("Enter the number of the media item: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < mediaLibrary.size()) {
            Media selectedMedia = mediaLibrary.get(index);
            System.out.println("Current price: " + selectedMedia.getPrice());
            System.out.print("Enter the new price: ");
            float newPrice = Float.parseFloat(scanner.nextLine());
            selectedMedia.setPrice(newPrice);
            System.out.println("Price updated successfully!");
        } else {
            System.out.println("Invalid selection. No changes made.");
        }
    }
}
