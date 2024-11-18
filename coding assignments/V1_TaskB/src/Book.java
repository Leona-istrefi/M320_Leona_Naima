
public class Book extends Media {
    private String isbn;

    public Book(String title, String creator, String isbn) {
        super(title, creator);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("ISBN: " + isbn);
    }
}
