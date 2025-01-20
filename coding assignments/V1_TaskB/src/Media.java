
public class Media {
    private String title;
    private int year;
    private float price;

    public Media(String title, int year, float price) {
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public float getPrice(){
        return price;
    }

    public void displayDetails() { //The displayDetails() method in Media is overridden in each subclass (DVD, CD, and Book):
        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);

    }

    public void setPrice(float price) {
        this.price = price;
    }
}
