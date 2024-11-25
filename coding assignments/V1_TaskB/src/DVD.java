
public class DVD extends Media {
    private int runtime; // runtime in minutes

    public DVD(String title, int year, float price, int runtime) {
        super(title, year, price);
        this.runtime = runtime;
    }

    public int getRuntime() {
        return runtime;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Runtime: " + runtime + " minutes");
    }
}
