
public class Book extends Media {
    private String isbn;

    public Book(String title, int year, float price, String isbn) {
        super(title, year, price);
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
